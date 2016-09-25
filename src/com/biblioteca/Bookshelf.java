package com.biblioteca;

import java.util.ArrayList;

/**
 * Created by Robin on 20/09/2016.
 */
class Bookshelf {
	public ArrayList<Book> books = new ArrayList();
    public ArrayList<Book> checkedInBooks;


	public void printCheckedInBookInfo() {
	    checkedInBooks = listCheckedInBooks();
		for (int i = 0; i < checkedInBooks.size(); i++) {
                System.out.printf("%-30s %-30s %-30s %n", books.get(i).getAuthor(), books.get(i).getTitle(), books.get(i).getDatePublishedString());
		}
	}
	public void addBooks(Book book) {books.add(book);}

    public void checkIn(Book book){
        if (books.contains(book)) {
            book.checkIn();
            System.out.println("Thank you for returning the book");
        } else {
            System.out.println("Book not found in library; please check spelling, and submit again");

        }
    }

    public void checkOut(Book book){
        checkedInBooks = listCheckedInBooks();
        if (checkedInBooks.contains(book)) {
            book.checkOut();
            System.out.println("Thank you! Enjoy the book");
        }else {
            System.out.println("That book is not available");
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

}



