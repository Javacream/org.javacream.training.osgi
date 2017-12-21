package org.javacream.storeservice.impl;

import org.javacream.storeservice.api.StoreService;

public class BooksStoreService implements StoreService{

	@Override
	public int getStock(String itemId){
		System.out.println("retrieving stock for isbn " + itemId);
		return 42;
	}
}
