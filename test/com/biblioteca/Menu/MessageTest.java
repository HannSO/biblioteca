package com.biblioteca.Menu;


import com.biblioteca.Menu.Message;
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
    public void printsHomeMessage() {
        message.printHome();
        assertEquals("Welcome to biblioteca homepage! Select category you want to investigate\n", outputStream.toString());
    }
}