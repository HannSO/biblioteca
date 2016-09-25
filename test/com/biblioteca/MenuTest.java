package com.biblioteca;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Robin on 24/09/2016.
 */
public class MenuTest {

    private Menu menu;

    @Before
    public void beforeEach(){
        menu = new Menu();
        menu.addMenuItem("1", "Display Books");
    }

    @Test
    public void displaysMenuOptions(){
        assertEquals("banana","....");
    }



}

