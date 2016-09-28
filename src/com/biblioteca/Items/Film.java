package com.biblioteca.Items;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Robin on 28/09/2016.
 */
public class Film {

    private String title;
    private String director;
    private Integer rating;
    private Date dateReleased;
    private String dateReleasedString;
    private Boolean checkedIn;


    public Film(String filmTitle, String filmDirector, String filmDateReleased, Integer filmRating) {
        title = filmTitle;
        director = filmDirector;
        dateReleasedString = filmDateReleased;
        setDateReleased(dateReleasedString);
        rating = filmRating;
        checkedIn = true;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void checkIn() {
        checkedIn = true;
    }

    public void checkOut() {
        checkedIn = false;
    }

    public String getDirector() {
        return director;
    }

    public void setDateReleased(String stringDate) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {

            dateReleased = df.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getDateReleased() {
        return dateReleased;
    }

    public String getReleaseDateAsString() {
        return dateReleasedString;
    }

    public Integer getRating() {
        return rating;
    }

}
