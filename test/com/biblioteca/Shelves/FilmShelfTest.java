package com.biblioteca.Shelves;

import com.biblioteca.Items.Film;
import com.biblioteca.Items.Item;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FilmShelfTest {
    private FilmShelf shelf;

    private Item checkedInItemInitially;
    private Item checkedInItemInitiallyTwo;
    private ShelfMessagePrinter message;
    private ByteArrayOutputStream outputStream;


    @Before
    public void beforeEach() {
        createMessagePrinterMockAndBehaviour();
        shelf = new FilmShelf(message);
        createItemMocksAndBehaviour();
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    public void createMessagePrinterMockAndBehaviour() {
        message = mock(ShelfMessagePrinter.class);
    }

    public void createItemMocksAndBehaviour() {
        checkedInItemInitially = mock(Item.class);
        checkedInItemInitiallyTwo = mock(Item.class);
        when(checkedInItemInitially.isCheckedIn()).thenReturn(true);
        when(checkedInItemInitiallyTwo.isCheckedIn()).thenReturn(true);
        when(checkedInItemInitially.getCreator()).thenReturn("David Fincher");
        when(checkedInItemInitiallyTwo.getCreator()).thenReturn("Hayao Miyazaki");
        when(checkedInItemInitially.getTitle()).thenReturn("Fight Club");
        when(checkedInItemInitiallyTwo.getTitle()).thenReturn("Spirited Away");
        when(checkedInItemInitially.getDateCirculatedString()).thenReturn("01/02/1999");
        when(checkedInItemInitiallyTwo.getDateCirculatedString()).thenReturn("01/02/2001");
    }

    @Test
    public void overridesShelfToDisplayCorrectHeaders() {
        shelf.printCheckedInItemsInfo();
        assertEquals("DIRECTOR                       TITLE                          RELEASE DATE                   \n", outputStream.toString());
    }


}

