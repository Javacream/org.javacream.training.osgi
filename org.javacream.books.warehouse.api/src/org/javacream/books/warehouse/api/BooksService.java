package org.javacream.books.warehouse.api;

public interface BooksService {

	public Book newBook(String title, double price);

	public Book findBookByIsbn(String isbn);
	

}