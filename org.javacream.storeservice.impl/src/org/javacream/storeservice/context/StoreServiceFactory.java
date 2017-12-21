package org.javacream.storeservice.context;

import org.javacream.storeservice.api.StoreService;
import org.javacream.storeservice.impl.BooksStoreService;

public abstract class StoreServiceFactory {

	private static StoreService instance;
	static{
		instance = new BooksStoreService();
	}
	public static StoreService getStoreService(){
		return instance;
	}
}
