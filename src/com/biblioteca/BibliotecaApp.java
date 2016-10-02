package com.biblioteca;


import com.biblioteca.Menu.HomeMenu;



import com.biblioteca.Menu.Message;
import com.biblioteca.Menu.HomeMenu;
import com.biblioteca.Shelves.Shelf;
import java.text.ParseException;
import java.util.ArrayList;

public class BibliotecaApp {

    private static Parser parser = new Parser();
    private static LibraryBuilder library;
    private static ArrayList<Shelf> shelves = new ArrayList();
    public static HomeMenu homeMenu = new HomeMenu();





    static {
        try {
            library = new LibraryBuilder();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static Message message = new Message();

    public static void main(String [] args) throws ParseException {
        library.buildAndLoadBookshelf();
        library.buildAndLoadFilmShelf();
        shelves.add(library.bookshelf);
        shelves.add(library.filmCase);
        homeMenu.createSpecificItemMenu();
        while (homeMenu.isQuit() == false ) {
            homeMenu.go(shelves);
        }
    }









}
