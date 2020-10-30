package com.javacream.training.osgi.store.impl;

import org.javacream.training.store.api.StoreService;

public class SophisticatedStoreService implements StoreService{

	@Override
	public int getStock(String category, String item) {
		return 9;
	}

}
