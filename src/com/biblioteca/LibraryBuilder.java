package com.biblioteca;


import com.biblioteca.Items.Book;
import com.biblioteca.Items.Film;
import com.biblioteca.Shelves.Bookshelf;
import com.biblioteca.Shelves.FilmShelf;

import java.text.ParseException;


/**
 * Created by Robin on 30/09/2016.
 */
public class LibraryBuilder {

    public Parser parser = new Parser();
    public Bookshelf bookshelf;
    public FilmShelf filmCase;
    private Book bookOne = new Book("Camus", parser.stringToDate("01/01/1955"), "The Outsider");
    private Book bookTwo = new Book("Voltaire",parser.stringToDate("1/1/1760"), "Candid");
    private Film filmOne = new Film("Fight Club",parser.stringToDate("01/01/1999"), "David Fincher");
    private Film filmTwo = new Film("Spirited Away", parser.stringToDate("01/01/2001"), "Hayao Miyazaki");

    public LibraryBuilder() throws ParseException {
    }

    public void buildAndLoadBookshelf() throws ParseException {
        bookshelf = new Bookshelf();
        bookshelf.addItems(bookOne);
        bookshelf.addItems(bookTwo);
    }

    public void buildAndLoadFilmShelf() throws ParseException{
        filmCase = new FilmShelf();
        filmCase.addItems(filmOne);
        filmCase.addItems(filmTwo);
    }

}
