package org.javacream.training.books.warehouse.osgi;

import java.util.Hashtable;

import org.javacream.books.isbngenerator.IsbnGenerator;
import org.javacream.training.books.warehouse.api.BooksService;
import org.javacream.training.books.warehouse.impl.SimpleBooksService;
import org.javacream.training.store.api.StoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

	private ServiceTracker<StoreService, StoreService> storeServiceTracker;
	private ServiceRegistration<BooksService> serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		SimpleBooksService bs = new SimpleBooksService();
		Filter filter = bundleContext.createFilter("(&(objectClass=" + StoreService.class.getName() + ")(type=simple))");
		storeServiceTracker = new ServiceTracker<>(bundleContext, filter, null);
		storeServiceTracker.open();
		StoreServiceProxy proxy = new StoreServiceProxy();
		proxy.setTracker(storeServiceTracker);
		bs.setStoreService(proxy);
		System.out.println("****************** "   + bundleContext.getServiceReferences(IsbnGenerator.class, null));
		IsbnGenerator isbnGenerator = bundleContext.getService(bundleContext.getServiceReferences(IsbnGenerator.class, null).iterator().next());
		bs.setIsbnGenerator(isbnGenerator);
		serviceRegistration = bundleContext.registerService(BooksService.class, bs, new Hashtable<>());

	}

	public void stop(BundleContext bundleContext) throws Exception {
		storeServiceTracker.close();
		serviceRegistration.unregister();
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
