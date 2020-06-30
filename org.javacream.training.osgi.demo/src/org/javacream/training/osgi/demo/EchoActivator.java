package org.javacream.training.osgi.demo;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class EchoActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Hello, starting " + this);
		EchoBusinessObject echoBusinessObject = new EchoBusinessObject();
		System.out.println(echoBusinessObject.doSomething("Moon"));
	}
	

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Hello, stopping " + this);
	}

}
