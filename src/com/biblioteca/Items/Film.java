package com.biblioteca.Items;

import java.util.Date;

/**
 * Created by Robin on 28/09/2016.
 */
public class Film {

    private String title;
    private String director;
    private Integer rating;
    private Date dateReleased;
    private Boolean checkedIn;


    public Film(String filmTitle, String filmDirector, Date filmDateReleased, Integer filmRating) {
        title = filmTitle;
        director = filmDirector;
        dateReleased = filmDateReleased;
        rating = filmRating;
        checkedIn = true;
    }

//    @Override
//    public void printCheckedInItemsInfo() {
//        checkedInItems = listCheckedInItems();
//        System.out.printf("%-30s %-30s %-30s %n","AUTHOR","TITLE","PUBLICATION DATE");
//        for (int i = 0; i < checkedInItems.size(); i++) {
//            System.out.printf("%-30s %-30s %-30s %n", items.get(i).getCreator(), items.get(i).getTitle(), items.get(i).getDateCirculatedString());
//        }
//    }


//    public boolean isCheckedIn() {
//        return checkedIn;
//    }
//
//    public void checkIn() {
//        checkedIn = true;
//    }
//
//    public void checkOut() {
//        checkedIn = false;
//    }
//
//    public String getDirector() {
//        return director;
//    }
//
//    public void setDateReleased(String stringDate) {
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//        try {
//
//            dateReleased = df.parse(stringDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Date getDateReleased() {
//        return dateReleased;
//    }
//
//    public String getReleaseDateAsString() {
//        return dateReleasedString;
//    }

    public Integer getRating() {
        return rating;
    }

}
