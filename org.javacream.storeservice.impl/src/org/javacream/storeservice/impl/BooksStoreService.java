package org.javacream.storeservice.impl;


import org.javacream.storeservice.api.StoreService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component
public class BooksStoreService implements StoreService{
	private int stock = 42;

	@Activate 
	public void init() {
		System.out.println("Initializing " + this);
	}
	@Override
	public int getStock(String itemId){
		System.out.println("retrieving stock for isbn " + itemId);
		return stock;
	}
	

}
