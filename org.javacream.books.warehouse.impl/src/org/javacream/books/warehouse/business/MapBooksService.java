package org.javacream.books.warehouse.business;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksService;
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
	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	private Map<String, Book> books = new HashMap<String, Book>();

	public MapBooksService() {

	}

	public Book newBook(String title, double price)
			{

		String isbn = isbnGenerator.nextIsbn();
		Book book = new Book();

		book.setIsbn(isbn);
		book.setTitle(title);
		book.setPrice(price);
		books.put(isbn, book);
		return book;
	}

	public Book findBookByIsbn(String isbn) {
		Book result = (Book) books.get(isbn);
		if (result != null) {
			int stock = storeService.getStock(isbn);
			result.setAvailable(stock > 0);
		}
		return result;
	}

}
