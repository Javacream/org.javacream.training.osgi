package org.javacream.isbngenerator.impl;

import org.javacream.isbngenerator.IsbnGenerator;

public class SequenceIsbnGenerator implements IsbnGenerator{

	private static int counter = 0;
	/* (non-Javadoc)
	 * @see org.javacream.isbngenerator.impl.IsbnGenerator#nextIsbn()
	 */
	@Override
	public String nextIsbn(){
		return "ISBN:" + counter++;
	}
}
