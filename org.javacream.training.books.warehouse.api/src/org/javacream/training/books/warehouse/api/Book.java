package org.javacream.training.books.warehouse.api;

public class Book {
private String title;
private String isbn;
private boolean available;
public boolean isAvailable() {
	return available;
}
public void setAvailable(boolean available) {
	this.available = available;
}
@Override
public String toString() {
	return "Book [title=" + title + ", isbn=" + isbn + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Book other = (Book) obj;
	if (isbn == null) {
		if (other.isbn != null)
			return false;
	} else if (!isbn.equals(other.isbn))
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
}
public Book(String title, String isbn) {
	super();
	this.title = title;
	this.isbn = isbn;
}
public String getTitle() {
	return title;
}
public String getIsbn() {
	return isbn;
}
}
