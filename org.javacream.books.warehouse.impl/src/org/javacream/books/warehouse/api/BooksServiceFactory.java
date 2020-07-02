package org.javacream.books.warehouse.api;

import org.javacream.books.warehouse.business.MapBooksService;

public class BooksServiceFactory {
	public static BooksService create() {
		return new MapBooksService();
	}
}
