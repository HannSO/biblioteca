package com.biblioteca.Items;

import java.util.Date;


public class Film extends Item{

    private String title;
    private String director;
    private Date dateReleased;
    private Boolean checkedIn;

    public Film(String t, Date d, String c) {
        super(t, d, c);
    }



}
