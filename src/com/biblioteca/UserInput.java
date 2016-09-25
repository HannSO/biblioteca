package com.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Robin on 25/09/2016.
 */


public class UserInput {

    public static String PROMPT = "Enter selection: ";

    public String returnString() {
        String inputLine = null;
        System.out.print(PROMPT);
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0 ) return null;
        } catch (IOException e) {
            System.out.println("IOException:" + e);
        }
        return inputLine;
    }

    public Integer returnInteger(){
        String string = returnString();
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e){
            System.out.print("Selection must be an integer. Please select again.");
            return 0;
        }
    }
}
