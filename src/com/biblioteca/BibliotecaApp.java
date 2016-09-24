package com.biblioteca;
/**
 * Created by Robin on 20/09/2016.
 */
public class BibliotecaApp {
    private Message message;
    private Bookshelf bookshelf;
    private static Book book;
    private static Book bookTwo;

    public static void main(String [] args) {
        Message message = new Message();
        message.print();
        Bookshelf bookshelf = new Bookshelf();
        loadBooks(bookshelf);
        bookshelf.printBookInfoInColumns();

    }

    private static void loadBooks(Bookshelf shelf) {
        bookTwo = new Book("Camus", "1/1/1955", "The Outsider");
        book = new Book("Voltaire","1/1/1760", "Candid");
        shelf.addBooks(bookTwo);
        shelf.addBooks(book);

    }
}
