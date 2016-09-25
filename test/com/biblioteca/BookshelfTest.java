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
    private Book book;
    private Book bookTwo;

    @Before
    public void beforeEach(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        bookshelf = new Bookshelf();
        book  = mock(Book.class);
        bookTwo = mock(Book.class);
        when(book.isCheckedIn()).thenReturn(true);
        when(bookTwo.isCheckedIn()).thenReturn(false);
    }

    @Test
    public void AddsBooks(){
        bookshelf.addBooks(book);
        assertEquals(book, bookshelf.books.get(0));
    }

    @Test
    public void GetsBooks(){
        ArrayList<Book> booksOnShelf;
        bookshelf.addBooks(book);
        booksOnShelf = bookshelf.books;
        assertEquals(book, booksOnShelf.get(0));
    }

    @Test
    public void printsBooksWithInfoAsColumns(){
        bookshelf.addBooks(book);
        bookshelf.addBooks(bookTwo);
        when(book.getAuthor()).thenReturn("Dickens");
        when(book.getDatePublishedString()).thenReturn("12/07/1860");
        when(book.getTitle()).thenReturn("Oliver Twist");
        when(bookTwo.getAuthor()).thenReturn("Dickens");
        when(bookTwo.getDatePublishedString()).thenReturn("11/07/1860");
        when(bookTwo.getTitle()).thenReturn("The Tale of Two Cities");
        bookshelf.printCheckedInBookInfo();
        assertEquals("Dickens                        Oliver Twist                   12/07/1860                     \n", outputStream.toString());


    }

}