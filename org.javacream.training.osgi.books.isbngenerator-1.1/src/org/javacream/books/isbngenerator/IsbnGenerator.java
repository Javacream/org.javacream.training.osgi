package org.javacream.books.isbngenerator;

import org.javacream.books.isbngenerator.impl.SequenceIsbnGenerator;

public interface IsbnGenerator {
	String next();
	static IsbnGenerator create() {
		return new SequenceIsbnGenerator();
	}
}
