package com.biblioteca;

import com.biblioteca.Items.Book;
import com.biblioteca.Shelves.Bookshelf;

import java.text.ParseException;


/**
 * Created by Robin on 20/09/2016.
 */
public class BibliotecaApp {
//    public Message message;
    
    private static Book book;
    private static Book bookTwo;
    private static OptionSelector optionSelector;
    private static UserInput userInput;
    private static Integer integerInput;
    private static Menu menu;
    private static Parser parser = new Parser();
    private static LibraryBuilder library;

    static {
        try {
            library = new LibraryBuilder();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static Message message = new Message();

    public static void main(String [] args) throws ParseException {
        createMenu();
        library.buildAndLoadBookshelf();
        library.buildAndLoadFilmShelf();
        message.print();
        showAndExecuteMenu(library.bookshelf);
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

    private static void loadBooks(Bookshelf bookshelf) throws ParseException {
        bookTwo = new Book("Camus", parser.stringToDate("01/01/1955"), "The Outsider");
        book = new Book("Voltaire",parser.stringToDate("1/1/1760"), "Candid");
        bookshelf.addItems(bookTwo);
        bookshelf.addItems(book);
    }
}
