package org.javacream.storeservice.api;

import org.javacream.storeservice.impl.BooksStoreService;

public class StoreServiceFactory {
public static StoreService create() {
	return new BooksStoreService();
}
}
