package com.biblioteca.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class MenuTest {

    private Menu menu;
    private ByteArrayOutputStream outputStream;

    @Before
    public void beforeEach(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        menu = new Menu();
    }
    @Test
    public void displayOptions(){
        menu.addMenuItem(1, "Display Books");
        menu.displayOptions();
        assertEquals("\nItem Menu:\n[1=Display Books]\n\n", outputStream.toString());
    }
    @Test
    public void addsMenuItem(){
        menu.addMenuItem(1, "Yes");
        assertEquals("Yes", menu.options.get(1));
    }
}

