package org.javacream.training.osgi.greeter;

import org.javacream.training.util.id.IdGenerator;
import org.javacream.training.util.id.IdGeneratorFactory;

public class SimpleGreeter {

	private IdGenerator idGenerator;
	{
		idGenerator = IdGeneratorFactory.create("sequence");
	}
	public String greet(String name){
		System.out.println("create greeting, id= " + idGenerator.next() + " for " + name);
		return "Hello " + name + "!";
	}
}
