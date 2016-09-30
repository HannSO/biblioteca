package com.biblioteca.Shelves;

import com.biblioteca.Items.Item;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Robin on 29/09/2016.
 */
public class FilmShelfTest {

    private FilmShelf shelf;
    private ByteArrayOutputStream outputStream;
    private Item checkedInItemInitially;
    private Item checkedOutItemInitially;


    @Before
    public void beforeEach() {
        shelf = new FilmShelf();
        outputStream = new ByteArrayOutputStream();
        checkedInItemInitially = mock(Item.class);
        checkedOutItemInitially = mock(Item.class);
        when(checkedInItemInitially.isCheckedIn()).thenReturn(true);
        when(checkedOutItemInitially.isCheckedIn()).thenReturn(false);
        when(checkedInItemInitially.getTitle()).thenReturn("Candid");
        when(checkedOutItemInitially.getTitle()).thenReturn("The Outsider");
    }

    //    @Test
//    public void getsBookFromShelfFromBookTitle(){
//        shelf.addItems(checkedInItemInitially);
//        assertEquals(checkedInItemInitially, shelf.retrieveBookFromTitle("Candid"));
//    }
    @Test
    public void AddsBooks() {
        shelf.addItems(checkedInItemInitially);
        assertEquals(checkedInItemInitially, shelf.items.get(0));
    }

    @Test
    public void ChecksInBooksWithSuccessMessage() {
        shelf.addItems(checkedOutItemInitially);
        shelf.checkIn(checkedOutItemInitially.getTitle());
        assertEquals("Thank you for returning the book.\n", outputStream.toString());
        verify(checkedOutItemInitially, times(1)).checkIn();
    }

    @Test
    public void UnsuccessfulCheckOutTellsUser() {
        shelf.addItems(checkedOutItemInitially);
        shelf.checkOut(checkedOutItemInitially.getCreator());
        assertEquals("That book is not available.\n", outputStream.toString());
        verify(checkedOutItemInitially, times(0)).checkOut();
    }

    @Test
    public void DoesntCheckInBookIfnotOnShelf() {
        shelf.checkIn(checkedOutItemInitially.getCreator());
        assertEquals("That is not a valid book to return.\n", outputStream.toString());
        assertEquals("That is not a valid book to return.\n", outputStream.toString());
        verify(checkedOutItemInitially, times(0)).checkIn();
    }

    @Test
    public void ChecksOutItemkWithSuccessMessage() {
        shelf.addItems(checkedInItemInitially);
        shelf.checkOut("The Outsider");
        verify(checkedInItemInitially, times(1)).checkOut();
        assertEquals("Thank you! Enjoy the book.\n", outputStream.toString());

    }

    @Test
    public void GetsBooks() {
        ArrayList<Item> itemsOnShelf;
        shelf.addItems(checkedInItemInitially);
        itemsOnShelf = shelf.items;
        assertEquals(checkedInItemInitially, itemsOnShelf.get(0));
    }
}