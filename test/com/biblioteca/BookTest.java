package com.biblioteca;

import com.biblioteca.Items.Book;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Robin on 24/09/2016.
 */
public class BookTest {

    private Book book;
    private String dateString;
    private Date date;

    @Before
    public void beforeEach(){
        dateString = "12/07/1860";
        book = new Book("Dickens",dateString,"Oliver Twist");
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            date = df.parse(dateString);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkOutchangesCheckedInStatusToFalse(){
        book.checkOut();
        assertEquals(false, book.isCheckedIn());
    }
    @Test
    public void checkInchangesCheckInStatusToFalse(){
        book.checkOut();
        book.checkIn();
        assertEquals(true, book.isCheckedIn());
    }
    @Test
    public void isCheckedInOnInitialization(){assertEquals(true,book.isCheckedIn());}
    @Test
    public void getsTitle(){assertEquals("Oliver Twist", book.getTitle());}
    @Test
    public void getsCreator(){assertEquals("Dickens", book.getCreator());}
    @Test
    public void getsDateCirculated(){assertEquals(date, book.getDateCirculated());}
//    @Test
//    public void getDatePublishedString(){assertEquals(dateString, book.getDatePublishedString());}
}