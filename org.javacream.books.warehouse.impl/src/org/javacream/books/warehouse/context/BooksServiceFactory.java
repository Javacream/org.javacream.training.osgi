package org.javacream.books.warehouse.context;

import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.business.MapBooksService;
import org.javacream.isbngenerator.IsbnGeneratorFactory;
import org.javacream.storeservice.context.StoreServiceFactory;

public abstract class BooksServiceFactory {

	private static BooksService instance;
	
	
	public static BooksService getBooksService(){
		if (instance == null){
			MapBooksService mapBooksService = new MapBooksService();
			mapBooksService.setIsbnGenerator(IsbnGeneratorFactory.getIsbnGenerator());
			mapBooksService.setStoreService(StoreServiceFactory.getStoreService());
			instance = mapBooksService;
		}
		return instance;
	}
}
