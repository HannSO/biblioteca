//package com.biblioteca;
//
//import com.biblioteca.Items.Film;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Created by Robin on 28/09/2016.
// */
//public class FilmTest {
//
//    private Film film;
//    private String dateString;
//    private Date date;
//    private Integer rating;
//
//
//    @Before
//    public void beforeEach(){
//
//        rating = 7;
//        film = new Film("Gladiator","Ridley Scott", dateString);
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//        try {
//            date = df.parse(dateString);
//        }
//        catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void checkOutchangesCheckedInStatusToFalse(){
//        film.checkOut();
//        assertEquals(false, film.isCheckedIn());
//    }
//
//    @Test
//    public void checkInchangesCheckInStatusToFalse(){
//        film.checkOut();
//        film.checkIn();
//        assertEquals(true, film.isCheckedIn());
//    }
//
//    @Test
//    public void getsAuthor(){assertEquals("Ridley Scott", film.getDirector());}
//
//    @Test
//    public void getsRating(){assertEquals(rating, film.getRating());}
//
//    @Test
//    public void getsReleaseDate(){assertEquals(date, film.getDateReleased());}
//    @Test
//    public void getDateReleasedString(){assertEquals(dateString, film.getReleaseDateAsString());}
//
//}