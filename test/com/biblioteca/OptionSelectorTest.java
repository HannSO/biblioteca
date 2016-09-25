package com.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.*;
/**
 * Created by Robin on 25/09/2016.
 */
public class OptionSelectorTest {

    private OptionSelector selector;
    private ByteArrayOutputStream outputStream;
    private Bookshelf bookshelf;

    @Before
    public void beforeEach(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        selector = new OptionSelector();
        bookshelf = mock(Bookshelf.class);
    }

    @Test
    public void optionOneCallsOnBookShelftoDisplayBooks(){
        selector.optionOne(bookshelf);
        verify(bookshelf, times(1)).printCheckedInBookInfo();
    }


//not sure how to test override?
}