package com.biblioteca;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Robin on 30/09/2016.
 */
public class Parser {
    private DateFormat df = new SimpleDateFormat("dd/mm/yyyy");


    public String dateToString(Date date){
        return df.format(date);
    }

    public Date stringToDate(String string) throws ParseException {
        Date date = df.parse(string);
        return date;
    }
}
