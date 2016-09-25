package com.biblioteca;
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

    public static void main(String [] args) {
        menu = new Menu();
        menu.addMenuItem(1, "Display books");
        Message message = new Message();
        message.print();
        Bookshelf bookshelf = new Bookshelf();
        loadBooks(bookshelf);
        menu.displayOptions();
        optionSelector = new OptionSelector();
        userInput = new UserInput();
        integerInput = userInput.returnInteger();
        optionSelector.select(integerInput, bookshelf);




    }

    private static void loadBooks(Bookshelf shelf) {
        bookTwo = new Book("Camus", "1/1/1955", "The Outsider");
        book = new Book("Voltaire","1/1/1760", "Candid");
        shelf.addBooks(bookTwo);
        shelf.addBooks(book);

    }
}
