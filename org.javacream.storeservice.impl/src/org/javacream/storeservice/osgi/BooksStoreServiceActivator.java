package org.javacream.storeservice.osgi;

import java.util.Dictionary;
import java.util.Hashtable;

import org.javacream.storeservice.api.StoreService;
import org.javacream.storeservice.impl.BooksStoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class BooksStoreServiceActivator implements BundleActivator {

	private ServiceRegistration<StoreService> serviceReference;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		BooksStoreService booksStoreService = new BooksStoreService();
		Dictionary<String, String> type = new Hashtable<String, String>();
		type.put("type", "book");
		serviceReference = bundleContext.registerService(StoreService.class, booksStoreService, type);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		serviceReference.unregister();
	}

}
