package com.biblioteca.Items;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;


public class ItemTest {

    private Item item;
    private Date date;
    private String title;
    private String creator;

    @Before
    public void beforeEach() {
        title = "Title";
        creator = "Creator";

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            date = df.parse("10/11/2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        item = new Item(title, date, creator);
    }

    @Test
    public void checkOutchangesCheckedInStatusToFalse(){
        item.checkOut();
        assertEquals(false, item.isCheckedIn());
    }

    @Test
    public void checkInchangesCheckInStatusToFalse(){
        item.checkOut();
        item.checkIn();
        assertEquals(true, item.isCheckedIn());
    }

    @Test
    public void isCheckedInOnInitialization(){assertEquals(true,item.isCheckedIn());}

    @Test
    public void getsTitle(){assertEquals(title, item.getTitle());}

    @Test
    public void getsCreator(){assertEquals(creator, item.getCreator());}

    @Test
    public void getsDateCirculated(){assertEquals(date, item.getDateCirculated());}

}