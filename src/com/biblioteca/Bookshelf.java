package com.biblioteca;

import java.util.ArrayList;

/**
 * Created by Robin on 20/09/2016.
 */
class Bookshelf {
	public ArrayList<Book> books = new ArrayList();
    public ArrayList<Book> checkedInbooks = new ArrayList();


	public void printCheckedInBookInfo() {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).isCheckedIn()) {
                System.out.printf("%-30s %-30s %-30s %n", books.get(i).getAuthor(), books.get(i).getTitle(), books.get(i).getDatePublishedString());
            }
		}
	}
	public void addBooks(Book book) {books.add(book);}

    public void checkIn(Book book){
        book.checkIn();
        System.out.println("Thank you for returning the book");
    }

    public void checkOut(Book book){
        book.checkOut();
       System.out.println("Thank you! Enjoy the book");

    }


}



