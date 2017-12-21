package org.javacream.books.warehouse.actor.osgi;

import java.util.HashMap;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		
		ServiceReference<BooksService> booksServiceReference = context.getServiceReference(BooksService.class);
		System.out.println(booksServiceReference);
		BooksService booksService =  context.getService(booksServiceReference);
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
