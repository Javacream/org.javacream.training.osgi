package org.javacream.isbngenerator.actor;

import org.javacream.isbngenerator.IsbnGenerator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class IsbnGeneratorActor implements BundleActivator{


	@Override
	public void start(BundleContext arg0) throws Exception {
		System.out.println(IsbnGenerator.create().nextIsbn());
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
	}
	
	
}
