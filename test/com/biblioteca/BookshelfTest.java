package com.biblioteca;

import static org.junit.Assert.*;

/**
 * Created by Robin on 22/09/2016.
 */


import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;



public class BookshelfTest {


    private Bookshelf bookshelf;
    private ByteArrayOutputStream outputStream;


    @Before
    public void beforeEach(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        bookshelf = new Bookshelf();
    }

    @Test
    public void printsBooksAsColumn(){
        bookshelf.printBooksAsColumn();
        assertEquals("The Bible\n" +
                "Gullivers Travells\n" +
                "The Outsider\n", outputStream.toString());
    }
    
}