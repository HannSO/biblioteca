package com.biblioteca;

import java.util.ArrayList;

/**
 * Created by Robin on 20/09/2016.
 */
class Bookshelf {
	public ArrayList<Book> books = new ArrayList();
    public ArrayList<Book> availableBooks;

	public void printBookInfoInColumns() {
		for (int i = 0; i < books.size(); i++) {
			System.out.printf("%-30s %-30s %-30s %n", books.get(i).getAuthor(), books.get(i).getTitle(), books.get(i).getDatePublishedString());
		}
	}

	public void addBooks(Book book) {books.add(book);}



	public ArrayList<Book> getBooks(){
	    return books;
    }





}



