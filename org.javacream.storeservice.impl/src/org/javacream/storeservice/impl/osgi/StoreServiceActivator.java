package org.javacream.storeservice.impl.osgi;

import java.util.Hashtable;

import org.javacream.storeservice.impl.BooksStoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class StoreServiceActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		BooksStoreService booksStoreService = new BooksStoreService();
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
	}

}
