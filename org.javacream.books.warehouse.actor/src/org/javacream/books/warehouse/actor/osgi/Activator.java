package org.javacream.books.warehouse.actor.osgi;

import java.util.HashMap;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.business.MapBooksService;
import org.javacream.isbngenerator.IsbnGenerator;
import org.javacream.isbngenerator.IsbnGeneratorFactory;
import org.javacream.storeservice.impl.BooksStoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		
		MapBooksService booksService =  new MapBooksService();
		BooksStoreService booksStoreService = new BooksStoreService();
		IsbnGenerator isbnGenerator = IsbnGeneratorFactory.getIsbnGenerator();
		booksService.setIsbnGenerator(isbnGenerator);
		booksService.setStoreService(booksStoreService);
		System.out.println(booksService);

		String isbn = booksService.newBook("OSGi in Action",
				new HashMap<String, Object>());
		Book book = booksService.findBookByIsbn(isbn);

		System.out.println("New book: " + book);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
	}

}
