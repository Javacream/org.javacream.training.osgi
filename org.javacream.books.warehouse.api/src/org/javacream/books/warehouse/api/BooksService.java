package org.javacream.books.warehouse.api;

import java.util.Collection;
import java.util.Map;

public interface BooksService {

	public abstract Book updateBook(Book bookDetailValue) throws BookException;

	public abstract void deleteBookByIsbn(String isbn) throws BookException;

	public abstract Collection<Book> findAllBooks();

	public String newBook(String title, Map<String, Object> options) throws BookException;

	public Book findBookByIsbn(String isbn) throws BookException;

}