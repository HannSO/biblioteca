package com.biblioteca.Shelves;

/**
 * Created by Robin on 29/09/2016.


/**
 * Created by Robin on 29/09/2016.
 */

public class ShelfMessagePrinter {

    public void printCheckInSuccess(){
        System.out.print("Thank you. Item checked in.");
    };

    public void printUnavailable(){
        System.out.print("Sorry, this item is not available");
    };

    public void printInvalidReturn(){
        System.out.print("That is not a valid book return.");
    }

    public void printCheckOutSuccess(){System.out.print("Item checked out. Enjoy!");}
}