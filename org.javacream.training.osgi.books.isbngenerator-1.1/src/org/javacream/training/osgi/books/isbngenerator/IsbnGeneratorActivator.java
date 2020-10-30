package org.javacream.training.osgi.books.isbngenerator;

import java.util.Hashtable;

import org.javacream.books.isbngenerator.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.SequenceIsbnGenerator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class IsbnGeneratorActivator implements BundleActivator {

	private ServiceRegistration<IsbnGenerator> serviceRegistry;

	@Override
	public void start(BundleContext bundleContext) throws Exception {

		serviceRegistry = bundleContext.registerService(IsbnGenerator.class, new SequenceIsbnGenerator(), new Hashtable<>());
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		serviceRegistry.unregister();
		
	}

}
