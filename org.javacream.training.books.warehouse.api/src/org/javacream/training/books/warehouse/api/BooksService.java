package org.javacream.training.books.warehouse.api;

public interface BooksService {

	String newBook(String title);
	Book findBookByIsbn(String isbn);
}
