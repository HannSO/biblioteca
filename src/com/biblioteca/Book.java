package com.biblioteca;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Robin on 23/09/2016.
 */
public class Book {

   private  String author;

    private Date  datePublished;

    private String title;

    private String stringDatePublished;


    public String getAuthor(){
        return author;
    }

    public void setTitle(String name){
        title = name;
    }

   public Date getDatePublished(){
       return datePublished;
   }

   public String getTitle(){
        return title;
    }

   public void setAuthor(String name){
       author = name;
   }

   public void setDatePublished(String stringDate){

       DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
       try {
           datePublished = df.parse(stringDate);
       }
       catch (ParseException e) {
           e.printStackTrace();
       }
       stringDatePublished = stringDate;

   }

   public String getDatePublishedString(){
       return stringDatePublished;
   }


}

