package org.javacream.books.warehouse.context;

import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.business.MapBooksService;
import org.javacream.isbngenerator.IsbnGeneratorFactory;
import org.javacream.storeservice.api.StoreService;

public abstract class BooksServiceFactory {

	private static BooksService instance;
	
	public static StoreService storeService;
	
	public static void init(){
		MapBooksService mapBooksService = new MapBooksService();
		mapBooksService.setIsbnGenerator(IsbnGeneratorFactory.getIsbnGenerator());
		mapBooksService.setStoreService(storeService);
		instance = mapBooksService;
	}
	public static BooksService getBooksService(){
		return instance;
	}
}
