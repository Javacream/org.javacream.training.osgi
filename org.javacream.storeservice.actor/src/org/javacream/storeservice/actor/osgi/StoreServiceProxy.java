package org.javacream.storeservice.actor.osgi;

import org.javacream.storeservice.api.StoreService;
import org.osgi.util.tracker.ServiceTracker;

public class StoreServiceProxy implements StoreService {
	private ServiceTracker<StoreService, StoreService> storeServiceTracker;

	public void setStoreServiceTracker(
			ServiceTracker<StoreService, StoreService> storeServiceTracker) {
		this.storeServiceTracker = storeServiceTracker;
	}

	@Override
	public int getStock(String itemId) {
		StoreService storeService;
		try {
			System.out.println("waiting for storeservice...");
			storeService = storeServiceTracker.waitForService(0);
			System.out.println("got storeservice, retrieving stock...");

			return storeService.getStock(itemId);
		} catch (InterruptedException e) {
			System.out.println("got interrupedException " + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (Exception e) {
			System.out.println("got Exception " + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
