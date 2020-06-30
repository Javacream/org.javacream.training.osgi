package org.javacream.training.osgi.demo;

import org.javacream.training.osgi.demo.lib.SimpleEcho;

public class EchoBusinessObject {

	public String doSomething(String message){
		return SimpleEcho.echo(message, true);
	}
}
