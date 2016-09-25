package com.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Robin on 22/09/2016.
 */

public class BookshelfTest {

    private Bookshelf bookshelf;
    private ByteArrayOutputStream outputStream;
    private Book checkedInBook;
    private Book checkedOutBook;

    @Before
    public void beforeEach(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        bookshelf = new Bookshelf();
        checkedInBook  = mock(Book.class);
        checkedOutBook = mock(Book.class);
        when(checkedInBook.isCheckedIn()).thenReturn(true);
        when(checkedOutBook.isCheckedIn()).thenReturn(false);
    }

    @Test
    public void AddsBooks(){
        bookshelf.addBooks(checkedInBook);
        assertEquals(checkedInBook, bookshelf.books.get(0));
    }

    @Test
    public void ChecksInBooksWithSuccessMessage(){
        bookshelf.addBooks(checkedOutBook);
        bookshelf.checkIn(checkedOutBook);
        assertEquals("Thank you for returning the book\n",outputStream.toString());
    }

    @Test
    public void ChecksOutBookWithSuccessMessage(){
        bookshelf.addBooks(checkedInBook);
        bookshelf.checkOut(checkedInBook);
        assertEquals("Thank you! Enjoy the book\n",outputStream.toString());
    }

    @Test
    public void GetsBooks(){
        ArrayList<Book> booksOnShelf;
        bookshelf.addBooks(checkedInBook);
        booksOnShelf = bookshelf.books;
        assertEquals(checkedInBook, booksOnShelf.get(0));
    }

    @Test
    public void printsBooksWithInfoAsColumns(){
        bookshelf.addBooks(checkedInBook);
        bookshelf.addBooks(checkedOutBook);
        when(checkedInBook.getAuthor()).thenReturn("Dickens");
        when(checkedInBook.getDatePublishedString()).thenReturn("12/07/1860");
        when(checkedInBook.getTitle()).thenReturn("Oliver Twist");
        when(checkedOutBook.getAuthor()).thenReturn("Dickens");
        when(checkedOutBook.getDatePublishedString()).thenReturn("11/07/1860");
        when(checkedOutBook.getTitle()).thenReturn("The Tale of Two Cities");
        bookshelf.printCheckedInBookInfo();
        assertEquals("Dickens                        Oliver Twist                   12/07/1860                     \n", outputStream.toString());


    }

}