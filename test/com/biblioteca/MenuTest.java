package com.biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


/**
 * Created by Robin on 24/09/2016.
 */
public class MenuTest {

    private Menu menu;
    private ByteArrayOutputStream outputStream;


    @Before
    public void beforeEach(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        menu = new Menu();
        menu.addMenuItem(1, "Display Books");

    }

    @Test

    public void displayOptions(){
        menu.displayOptions();
        assertEquals("{1=Display Books}\n", outputStream.toString());
    }

}

