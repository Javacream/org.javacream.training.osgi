package org.javacream.books.warehouse.osgi;

import java.util.Hashtable;

import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.business.MapBooksService;
import org.javacream.isbngenerator.IsbnGenerator;
import org.javacream.storeservice.api.StoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class BooksServiceActivator implements BundleActivator {


	private ServiceRegistration<BooksService> booksService;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		ServiceReference<StoreService> storeServiceReference;
		ServiceReference<IsbnGenerator> isbnGeneratorServiceReference;
		storeServiceReference = bundleContext.getServiceReferences(StoreService.class, "(&(type=book))").iterator().next();
		isbnGeneratorServiceReference = bundleContext.getServiceReferences(IsbnGenerator.class, "(&(type=random))").iterator().next();
		StoreService storeService = bundleContext.getService(storeServiceReference); 
		
		IsbnGenerator isbnGenerator = bundleContext.getService(isbnGeneratorServiceReference); 
		MapBooksService mapBooksService = new MapBooksService();
		mapBooksService.setIsbnGenerator(isbnGenerator);
		mapBooksService.setStoreService(storeService);
		Hashtable<String, String> qualifier = new Hashtable<>();
		booksService = bundleContext.registerService(BooksService.class, mapBooksService, qualifier);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		booksService.unregister();
	}

}