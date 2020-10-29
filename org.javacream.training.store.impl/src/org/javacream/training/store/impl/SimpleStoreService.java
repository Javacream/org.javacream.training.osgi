package org.javacream.training.store.impl;

import org.javacream.training.store.api.StoreService;

public class SimpleStoreService implements StoreService{

	@Override
	public int getStock(String category, String item) {
		return 42;
	}

}
