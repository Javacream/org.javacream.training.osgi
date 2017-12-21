package org.javacream.isbngenerator.osgi;

import org.javacream.isbngenerator.IsbnGeneratorFactory;
import org.javacream.isbngenerator.impl.IsbnGeneratorImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class IsbnGeneratorActivator implements BundleActivator{

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		IsbnGeneratorImpl isbnGenerator = new IsbnGeneratorImpl();
		IsbnGeneratorFactory.isbnGenerator = isbnGenerator;
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
	
	}

}
