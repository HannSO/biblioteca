package com.biblioteca.Items;

import java.util.Date;

/**
 * Created by Robin on 28/09/2016.
 */
public class Item {

    private String title;
    private Date dateCirculated;
    private String creator;
    private Boolean checkedIn;


    public Item(String t, Date d, String c) {
        title = t;
        dateCirculated = d;
        creator = c;
        checkedIn = true;
    }

    public boolean isCheckedIn(){return checkedIn;}

    public void checkIn(){checkedIn=true;}

    public void checkOut(){checkedIn = false;}

    public String getCreator(){return creator;}

    public Date getDateCirculated(){return dateCirculated;}

    public String getTitle(){return title;}
    

}
