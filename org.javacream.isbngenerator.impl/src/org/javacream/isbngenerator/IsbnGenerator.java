package org.javacream.isbngenerator;

import org.javacream.isbngenerator.impl.SequenceIsbnGenerator;

public interface IsbnGenerator {

	public abstract String nextIsbn();
	static IsbnGenerator create() {
		return new SequenceIsbnGenerator();
	}
}