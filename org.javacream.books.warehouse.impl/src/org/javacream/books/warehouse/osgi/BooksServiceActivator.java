package org.javacream.books.warehouse.osgi;

import org.javacream.books.warehouse.context.BooksServiceFactory;
import org.javacream.storeservice.api.StoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class BooksServiceActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		StoreService storeService = bundleContext.getService(bundleContext.getServiceReferences(StoreService.class, "(&(type=book))").iterator().next()); 
		BooksServiceFactory.storeService = storeService;
		BooksServiceFactory.init();
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
	}

}
