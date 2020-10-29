package org.javacream.books.isbngenerator;

import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;

public interface IsbnGenerator {
	String next();
	static IsbnGenerator create() {
		return new RandomIsbnGenerator();
	}
}
