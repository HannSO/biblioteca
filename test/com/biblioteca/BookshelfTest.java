package com.biblioteca;

import com.biblioteca.Items.Book;

import com.biblioteca.Shelves.Bookshelf;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Robin on 22/09/2016.
 */

public class BookshelfTest {

    private Bookshelf bookshelf;
    private ByteArrayOutputStream outputStream;
    private Book checkedInBookInitially;
    private Book checkedOutBookInitially;


    @Before
    public void beforeEach(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        bookshelf = new Bookshelf();
        checkedInBookInitially  = mock(Book.class);
        checkedOutBookInitially = mock(Book.class);
        when(checkedInBookInitially.isCheckedIn()).thenReturn(true);
        when(checkedOutBookInitially.isCheckedIn()).thenReturn(false);
        when(checkedInBookInitially.getTitle()).thenReturn("Candid");
    }
    @Test
    public void getsBookFromShelfFromBookTitle(){
        bookshelf.addBooks(checkedInBookInitially);
        assertEquals(checkedInBookInitially, bookshelf.retrieveBookFromTitle("Candid"));
    }
    @Test
    public void AddsBooks(){
        bookshelf.addBooks(checkedInBookInitially);
        assertEquals(checkedInBookInitially, bookshelf.books.get(0));
    }
    @Test
    public void ChecksInBooksWithSuccessMessage(){
        bookshelf.addBooks(checkedOutBookInitially);
        bookshelf.checkIn(checkedOutBookInitially);
        assertEquals("Thank you for returning the book.\n",outputStream.toString());
        verify(checkedOutBookInitially, times(1)).checkIn();
    }
    @Test
    public void UnsuccessfulCheckOutTellsUser(){
        bookshelf.addBooks(checkedOutBookInitially);
        bookshelf.checkOut(checkedOutBookInitially);
        assertEquals("That book is not available.\n",outputStream.toString());
        verify(checkedOutBookInitially, times(0)).checkOut();
    }
    @Test
    public void DoesntCheckInBookIfnotOnShelf(){
        bookshelf.checkIn(checkedOutBookInitially);
        assertEquals("That is not a valid book to return.\n",outputStream.toString());
        assertEquals("That is not a valid book to return.\n",outputStream.toString());
        verify(checkedOutBookInitially, times(0)).checkIn();
    }
    @Test
    public void ChecksOutBookWithSuccessMessage(){
        bookshelf.addBooks(checkedInBookInitially);
        bookshelf.checkOut(checkedInBookInitially);
        assertEquals("Thank you! Enjoy the book.\n",outputStream.toString());
        verify(checkedInBookInitially, times(1)).checkOut();
    }
    @Test
    public void GetsBooks(){
        ArrayList<Book> booksOnShelf;
        bookshelf.addBooks(checkedInBookInitially);
        booksOnShelf = bookshelf.books;
        assertEquals(checkedInBookInitially, booksOnShelf.get(0));
    }
    @Test
    public void printsBooksWithInfoAsColumns(){
        bookshelf.addBooks(checkedInBookInitially);
        bookshelf.addBooks(checkedOutBookInitially);
        when(checkedInBookInitially.getCreator()).thenReturn("Dickens");
        when(checkedInBookInitially.getTitle()).thenReturn("Oliver Twist");
        when(checkedOutBookInitially.getCreator()).thenReturn("Dickens");
//        when(checkedOutBookInitially.getDatePublishedString()).thenReturn("11/07/1860");
        when(checkedOutBookInitially.getTitle()).thenReturn("The Tale of Two Cities");
        bookshelf.printCheckedInItemInfo();
        assertEquals("AUTHOR                         TITLE                          PUBLICATION DATE               \nDickens                        Oliver Twist                   12/07/1860                     \n", outputStream.toString());


    }
}