package org.javacream.training.osgi.demo;

public class EchoBusinessObject {

	public String doSomething(String parameter){
		return new StringBuilder(parameter).reverse().toString();
	}
}
