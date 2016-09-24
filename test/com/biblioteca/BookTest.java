package com.biblioteca;

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
    public void getsTitle(){assertEquals("Oliver Twist", book.getTitle());}
    @Test
    public void getsAuthor(){assertEquals("Dickens", book.getAuthor());}
    @Test
    public void getsDatePublished(){assertEquals(date, book.getDatePublished());}
    @Test
    public void getDatePublishedString(){assertEquals(dateString, book.getDatePublishedString());}
}