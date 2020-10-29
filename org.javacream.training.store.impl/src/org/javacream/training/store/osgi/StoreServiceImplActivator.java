package org.javacream.training.store.osgi;

import org.javacream.training.store.impl.SimpleStoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class StoreServiceImplActivator implements BundleActivator {

	@Override
	public void start(BundleContext arg0) throws Exception {
		System.out.println(new SimpleStoreService().getStock("this", "that"));
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
	}

}
