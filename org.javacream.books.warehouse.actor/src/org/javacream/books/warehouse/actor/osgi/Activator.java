package org.javacream.books.warehouse.actor.osgi;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.BooksServiceFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		BooksService booksService =  BooksServiceFactory.create();
		System.out.println(booksService);

		Book book = booksService.newBook("OSGi in Action",
				19.99);
		System.out.println("New book: " + book);
		Book book2 = booksService.findBookByIsbn(book.getIsbn());
		System.out.println("Searched book: " + book2);

	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
	}

}
