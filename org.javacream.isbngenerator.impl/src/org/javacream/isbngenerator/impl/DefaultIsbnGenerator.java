package org.javacream.isbngenerator.impl;

import org.javacream.isbngenerator.IsbnGenerator;

public class DefaultIsbnGenerator implements IsbnGenerator{

	@Override
	public String nextIsbn(){
		return "ISBN";
	}
}
