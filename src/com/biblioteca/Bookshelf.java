package com.biblioteca;

/**
 * Created by Robin on 20/09/2016.
 */
class Bookshelf {

    private static String[] books = {"The Bible", "Gullivers Travells", "The Outsider"};


	public void printBooksAsColumn() {
		for (int i = 0; i < books.length; i++) {
			System.out.print(books[i] + "\n");
		}
	}
}



