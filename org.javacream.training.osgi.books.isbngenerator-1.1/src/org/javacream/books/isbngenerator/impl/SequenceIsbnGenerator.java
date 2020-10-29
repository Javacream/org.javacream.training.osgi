package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.IsbnGenerator;

public class SequenceIsbnGenerator implements IsbnGenerator{
	private int counter;
	private String suffix;
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	@Override
	public String next() {
		return counter++ + "-" + suffix;
	}
	
	

}
