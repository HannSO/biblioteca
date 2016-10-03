package com.biblioteca.Shelves;


public class ShelfMessagePrinter {

    public void printCheckInSuccess(){
        System.out.println("Thank you. Item checked in.");
    };

    public void printUnavailable(){
        System.out.println("Sorry, this item is not available");
    };

    public void printInvalidReturn(){
        System.out.println("That is not a valid item return.");
    }

    public void printCheckOutSuccess(){System.out.println("Item checked out. Enjoy!");}

}