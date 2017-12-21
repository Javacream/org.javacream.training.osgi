package org.javacream.isbngenerator.impl;

import org.javacream.isbngenerator.IsbnGenerator;

public class IsbnGeneratorImpl implements IsbnGenerator{

	/* (non-Javadoc)
	 * @see org.javacream.isbngenerator.impl.IsbnGenerator#nextIsbn()
	 */
	@Override
	public String nextIsbn(){
		return "ISBN:" + System.currentTimeMillis();
	}
}
