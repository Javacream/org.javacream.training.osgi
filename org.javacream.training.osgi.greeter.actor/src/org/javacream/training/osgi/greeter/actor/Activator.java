package org.javacream.training.osgi.greeter.actor;

import org.javacream.training.osgi.greeter.SimpleGreeter;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public void start(BundleContext bundleContext) throws Exception {
		SimpleGreeter simpleGreeter = new SimpleGreeter();
		System.out.println(simpleGreeter.greet("Hugo"));
	}

	public void stop(BundleContext bundleContext) throws Exception {
	}

}
