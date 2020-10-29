package org.javacream.books.isbngenerator.impl;

import java.util.Random;

import org.javacream.books.isbngenerator.IsbnGenerator;

public class RandomIsbnGenerator implements IsbnGenerator{
	private Random random = new Random(this.hashCode() + System.currentTimeMillis());
	private String prefix;
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	@Override
	public String next() {
		return prefix + "-" + Math.abs(random.nextInt());
	}
	
	

}
