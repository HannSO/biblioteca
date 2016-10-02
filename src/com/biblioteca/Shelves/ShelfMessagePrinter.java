package com.biblioteca.Shelves;


public class ShelfMessagePrinter {

    public void printCheckInSuccess(){
        System.out.print("Thank you. Item checked in.");
    };

    public void printUnavailable(){
        System.out.print("Sorry, this item is not available");
    };

    public void printInvalidReturn(){
        System.out.print("That is not a valid item return.");
    }

    public void printCheckOutSuccess(){System.out.print("Item checked out. Enjoy!");}

}