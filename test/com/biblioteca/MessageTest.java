package com.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


/**
 * Created by Robin on 20/09/2016.
 */
public class MessageTest {

    private Message message;
    private ByteArrayOutputStream outputStream;

    @Before
    public void beforeEach(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        message = new Message();
    }

    @Test
    public void printsMessage() {
        message.print();
        assertEquals("Welcome to biblioteca!\n", outputStream.toString());
    }
}