package com.biblioteca;

import com.biblioteca.Items.Book;
import com.biblioteca.Shelves.Bookshelf;

import java.text.ParseException;


/**
 * Created by Robin on 20/09/2016.
 */
public class BibliotecaApp {
    private Message message;
    public Bookshelf bookshelf;
    private static Book book;
    private static Book bookTwo;
    private static OptionSelector optionSelector;
    private static UserInput userInput;
    private static Integer integerInput;
    private static Menu menu;
    private static Parser parser = new Parser();
    public static void main(String [] args) {
        createMenu();
        Bookshelf bookshelf = new Bookshelf();
        loadBooks(bookshelf);
        Message message = new Message();
        message.print();
        showAndExecuteMenu(bookshelf);
    }

    public static void createMenu(){
        menu = new Menu();
        menu.addMenuItem(1, "Display books");
        menu.addMenuItem(2, "CheckInBook");
        menu.addMenuItem(3, "CheckOutBook");
        menu.addMenuItem(99, "Quit");

    }

    public static void showAndExecuteMenu(Bookshelf bookshelf){
        optionSelector = new OptionSelector();
        userInput = new UserInput();
        menu.displayOptions();
        userInput.showPrompt("Enter selection: ");
        integerInput = userInput.returnInteger();
        while (integerInput != 99) {
            optionSelector.select(integerInput, bookshelf);
            menu.displayOptions();
            userInput.showPrompt("Enter selection:");
            integerInput = userInput.returnInteger();
        }
        System.out.print("\nYou have quit Biblioteca. Goodbye.\n");
    }

    private static void loadBooks(Bookshelf shelf) throws ParseException {
        bookTwo = new Book("Camus", parser.stringToDate("01/01/1955"), "The Outsider");
        book = new Book("Voltaire",parser.stringToDate("1/1/1760"), "Candid");
        shelf.addBooks(bookTwo);
        shelf.addBooks(book);
    }
}
