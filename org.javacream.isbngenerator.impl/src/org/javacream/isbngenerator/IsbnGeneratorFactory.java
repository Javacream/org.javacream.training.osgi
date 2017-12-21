package org.javacream.isbngenerator;


public abstract class IsbnGeneratorFactory {
	
	public static IsbnGenerator isbnGenerator;
	
	public static IsbnGenerator getIsbnGenerator(){
		return isbnGenerator;
	}


}
