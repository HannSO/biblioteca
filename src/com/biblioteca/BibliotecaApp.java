package com.biblioteca;
import com.biblioteca.Message;

/**
 * Created by Robin on 20/09/2016.
 */
public class BibliotecaApp {
    private Message message;
    private Bookshelf bookshelf;

    public static void main(String [] args) {
        Message message = new Message();
        message.print();
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.printBooksAsColumn();
    }
}
