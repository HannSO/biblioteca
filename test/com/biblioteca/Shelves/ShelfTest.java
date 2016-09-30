package com.biblioteca.Shelves;

import com.biblioteca.Items.Item;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Robin on 30/09/2016.
 */
public class ShelfTest {


        private Shelf shelf;
        private ByteArrayOutputStream outputStream;
        private Item checkedInItemInitially;
        private Item checkedOutItemInitially;
        private ShelfMessagePrinter message;


        @Before
        public void beforeEach() {
            createMessagePrinterMockAndBehaviour();
            shelf = new Shelf(message);
            outputStream = new ByteArrayOutputStream();
            createItemMocksAndBehaviour();

        }

        public void createMessagePrinterMockAndBehaviour() {
            message = mock(ShelfMessagePrinter.class);
        }

        public void createItemMocksAndBehaviour() {
            checkedInItemInitially = mock(Item.class);
            checkedOutItemInitially = mock(Item.class);
            when(checkedInItemInitially.isCheckedIn()).thenReturn(true);
            when(checkedOutItemInitially.isCheckedIn()).thenReturn(false);
            when(checkedInItemInitially.getCreator()).thenReturn("Candid");
            when(checkedOutItemInitially.getCreator()).thenReturn("The Outsider");
        }

        @Test
        public void AddsBooks() {
            shelf.addItems(checkedInItemInitially);
            assertEquals(checkedInItemInitially, shelf.items.get(0));
        }

        @Test
        public void ChecksInBooksWithSuccessMessage() {
            shelf.addItems(checkedOutItemInitially);
            shelf.checkIn(checkedOutItemInitially.getTitle());
            verify(checkedOutItemInitially, times(1)).checkIn();
            verify(message, times(1)).printCheckInSuccess();
        }

        @Test
        public void UnsuccessfulCheckOutTellsUser() {
            shelf.addItems(checkedOutItemInitially);
            shelf.checkOut(checkedOutItemInitially.getCreator());
            verify(checkedOutItemInitially, times(0)).checkOut();
            verify(message, times(1)).printCheckInSuccess();
        }

        @Test
        public void DoesNotCheckInBookIfNotOnShelf() {
            shelf.checkIn(checkedOutItemInitially.getCreator());
            verify(message, times(1)).printInvalidReturn();
            verify(checkedOutItemInitially, times(0)).checkIn();
        }

        @Test
        public void ChecksOutItemWithSuccessMessage() {
            shelf.addItems(checkedInItemInitially);
            shelf.checkOut("The Outsider");
            verify(checkedInItemInitially, times(1)).checkOut();
            assertEquals("Thank you! Enjoy the book.\n", outputStream.toString());
        }


//        @Test
//        public void GetsBooks() {
//            ArrayList<Item> itemsOnShelf;
//            shelf.addItems(checkedInItemInitially);
//            itemsOnShelf = shelf.items;
//            assertEquals(checkedInItemInitially, itemsOnShelf.get(0));
//        }
}

