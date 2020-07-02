package org.javacream.storeservice.impl;

import org.javacream.storeservice.api.StoreService;

public class BooksStoreService implements StoreService{
	private int stock = 42;

	@Override
	public int getStock(String itemId){
		System.out.println("retrieving stock for isbn " + itemId);
		return stock;
	}
	

}
