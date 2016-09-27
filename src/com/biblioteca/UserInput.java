package com.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Robin on 25/09/2016.
 */


public class UserInput {

    public void showPrompt(String prompt) {
        System.out.print(prompt + "\n");
    }

    public String returnString() {
        String inputLine = null;
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
            System.out.print("Selection must be an integer. ");
            return 0;
        }
    }
}
