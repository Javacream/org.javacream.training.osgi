package org.javacream.training.books.warehouse.impl;

import org.javacream.books.isbngenerator.IsbnGenerator;
import org.javacream.training.books.warehouse.api.Book;
import org.javacream.training.books.warehouse.api.BooksService;
import org.javacream.training.store.api.StoreService;

public class SimpleBooksService implements BooksService{

	private IsbnGenerator isbnGenerator;
	private StoreService storeService;
	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	@Override
	public String newBook(String title) {
		String newIsbn = isbnGenerator.next();
		return newIsbn;
	}

	@Override
	public Book findBookByIsbn(String isbn) {
		boolean available = storeService.getStock("books", isbn) > 0;
		Book b = new Book("ISBN1", "Title");
		b.setAvailable(available);
		return b;
	}

}
