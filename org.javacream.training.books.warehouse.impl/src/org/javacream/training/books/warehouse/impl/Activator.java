package org.javacream.training.books.warehouse.impl;

import org.javacream.books.isbngenerator.IsbnGenerator;
import org.javacream.training.store.api.StoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

	public void start(BundleContext bundleContext) throws Exception {
		SimpleBooksService bs = new SimpleBooksService();
		IsbnGenerator isbnGenerator = bundleContext.getService(bundleContext.getServiceReferences(IsbnGenerator.class, null).iterator().next());
		bs.setIsbnGenerator(isbnGenerator);
		Filter filter = bundleContext.createFilter("(&(objectClass=" + StoreService.class.getName() + ")&(type=simple))");
		ServiceTracker<StoreService, StoreService> storeServiceTracker = new ServiceTracker<>(bundleContext, filter, null);
		storeServiceTracker.open();
		StoreServiceProxy proxy = new StoreServiceProxy();
		proxy.setTracker(storeServiceTracker);
		bs.setStoreService(proxy);

	}

	public void stop(BundleContext bundleContext) throws Exception {
	}

	class StoreServiceProxy implements StoreService{
		private ServiceTracker<StoreService, StoreService> tracker;

		public void setTracker(ServiceTracker<StoreService, StoreService> tracker) {
			this.tracker = tracker;
		}

		@Override
		public int getStock(String category, String item) {
				try {
					StoreService simpleStoreService = tracker.waitForService(5000);
					 return simpleStoreService.getStock("this", "that");
				} catch (InterruptedException e) {
					e.printStackTrace();
					return 0;
				}		
			}
	}
}
