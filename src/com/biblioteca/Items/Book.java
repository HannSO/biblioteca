package com.biblioteca.Items;

import java.util.Date;

/**
 * Created by Robin on 23/09/2016.
 */
public class Book extends Item {

    private  String author;
    private Date datePublished;
    private String title;
    private String stringDatePublished;
    private Boolean checkedIn;

    public Book(String t, Date d, String c) {
        super(t, d, c);
    }


}

