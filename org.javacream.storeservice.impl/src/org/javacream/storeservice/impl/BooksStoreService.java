package org.javacream.storeservice.impl;

import org.javacream.storeservice.api.StoreService;

public class BooksStoreService implements StoreService{
	private int stock;
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public int getStock(String itemId){
		System.out.println("retrieving stock for isbn " + itemId);
		return stock;
	}
	
	public void init(){
		System.out.println("Initializing " + this);
	}
	public void stop(){
		System.out.println("Stopping " + this);
	}

}
