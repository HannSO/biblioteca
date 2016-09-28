package com.biblioteca;

import com.biblioteca.Items.Book;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Robin on 20/09/2016.
 */
class Bookshelf {
	public ArrayList<Book> books = new ArrayList();
    public ArrayList<Book> checkedInBooks;


	public void printCheckedInBookInfo() {
	    checkedInBooks = listCheckedInBooks();
        System.out.printf("%-30s %-30s %-30s %n","AUTHOR","TITLE","PUBLICATION DATE");
		for (int i = 0; i < checkedInBooks.size(); i++) {
                System.out.printf("%-30s %-30s %-30s %n", books.get(i).getAuthor(), books.get(i).getTitle(), books.get(i).getDatePublishedString());
		}
	}
	public void addBooks(Book book) {books.add(book);}

    public void checkIn(Book book){
        if (books.contains(book) && !(book.isCheckedIn())) {
            book.checkIn();
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    public void checkOut(Book book){
        checkedInBooks = listCheckedInBooks();
        if (checkedInBooks.contains(book)) {
            book.checkOut();
            System.out.println("Thank you! Enjoy the book.");
        }else {
            System.out.println("That book is not available.");
        }

    }

    private ArrayList<Book> listCheckedInBooks(){
        checkedInBooks = new ArrayList();
        for (int i = 0; i <books.size(); i++){
            if (books.get(i).isCheckedIn()){
                checkedInBooks.add(books.get(i));
            }
        }
        return checkedInBooks;
    }

    public Book retrieveBookFromTitle(String bookTitle) {
        Boolean found = false;
        Integer foundIndex = 0;
        for (int i = 0; i < books.size(); i++) {
            if (Objects.equals(books.get(i).getTitle(),bookTitle)) {
                found = true;
                foundIndex = i;
            }
        }
        if (found) {
            return books.get(foundIndex);
        }   else {
            return null;
        }
    }
}

