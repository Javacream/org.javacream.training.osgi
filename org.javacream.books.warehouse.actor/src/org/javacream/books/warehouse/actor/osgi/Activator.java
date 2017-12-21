package org.javacream.books.warehouse.actor.osgi;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.business.MapBooksService;
import org.javacream.isbngenerator.IsbnGenerator;
import org.javacream.isbngenerator.IsbnGeneratorFactory;
import org.javacream.storeservice.impl.BooksStoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		ScheduledExecutorService executorService = Executors
				.newScheduledThreadPool(1);
		executorService
				.schedule(
						() -> {
							MapBooksService booksService = new MapBooksService();
							BooksStoreService booksStoreService = new BooksStoreService();
							IsbnGenerator isbnGenerator = IsbnGeneratorFactory
									.getIsbnGenerator();
							booksService.setIsbnGenerator(isbnGenerator);
							booksService.setStoreService(booksStoreService);
							System.out.println(booksService);
							try {
								String isbn = booksService.newBook(
										"OSGi in Action",
										new HashMap<String, Object>());
								Book book = booksService.findBookByIsbn(isbn);

								System.out.println("New book: " + book);
							} catch (BookException e) {
								e.printStackTrace();
							}
						}, 4, TimeUnit.SECONDS);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
	}

}
