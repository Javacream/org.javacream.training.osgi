package org.javacream.books.warehouse.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.SchoolBook;
import org.javacream.books.warehouse.api.SpecialistBook;
import org.javacream.isbngenerator.IsbnGenerator;
import org.javacream.storeservice.api.StoreService;

/**
 * @author Dr. Rainer Sawitzki
 * @company Javacream
 * @mailto rainer.sawitzki@javacream.org
 * 
 */

public class MapBooksService implements BooksService {

	private IsbnGenerator isbnGenerator;
	private StoreService storeService;
	private Map<String, Book> books = new HashMap<String, Book>();

	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public void setBooks(Map<String, Book> books) {
		this.books = books;
	}

	public MapBooksService() {

	}

	public String newBook(String title, Map<String, Object> options)
			throws BookException {

		String isbn = isbnGenerator.nextIsbn();
		Book book = new Book();
		String topic = (String) options.get("topic");
		if (topic != null) {
			SpecialistBook specialistBook = new SpecialistBook();
			specialistBook.setTopic(topic);
			book = specialistBook;
		}
		String subject = (String) options.get("subject");
		Integer year = (Integer) options.get("year");
		if (subject != null && year != null) {
			SchoolBook schoolBook = new SchoolBook();
			schoolBook.setYear(year);
			schoolBook.setTitle(subject);
			book = schoolBook;
		}

		book.setIsbn(isbn);
		book.setTitle(title);
		books.put(isbn, book);
		return isbn;
	}

	public Book findBookByIsbn(String isbn) throws BookException {
		Book result = (Book) books.get(isbn);
		if (result == null) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND,
					isbn);
		}
		int stock = storeService.getStock(isbn);
		result.setAvailable(stock > 0);
		// Don't return internal Book if you don't use a database!
		result = (Book) SerializationUtils.clone(result);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.javacream.books.warehouse.BooksService#updateBook(org.javacream.books
	 * .warehouse.value.Book)
	 */
	public Book updateBook(Book bookDetailValue) throws BookException {
		// Take a copy to prevent external manipulation!
		bookDetailValue = (Book) SerializationUtils.clone(bookDetailValue);
		Book value = books.get(bookDetailValue.getIsbn());
		value.setTitle(bookDetailValue.getTitle());
		value.setPrice(bookDetailValue.getPrice());
		value.setAvailable(bookDetailValue.isAvailable());
		return value;
	}

	public void init() {
		try {
			String isbn = newBook("OSGi in Action",
					new HashMap<String, Object>());
			Book book = findBookByIsbn(isbn);

			System.out.println("New book: " + book);
		} catch (BookException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.javacream.books.warehouse.BooksService#deleteBookByIsbn(java.lang
	 * .String)
	 */
	public void deleteBookByIsbn(String isbn) throws BookException {
		Object result = books.remove(isbn);
		if (result == null) {
			throw new BookException(
					BookException.BookExceptionType.NOT_DELETED, isbn);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.javacream.books.warehouse.BooksService#findAllBooks()
	 */
	public Collection<Book> findAllBooks() {
		return SerializationUtils.clone(new ArrayList<Book>(books.values()));
		// return new ArrayList<Book>(books.values());
	}

}
