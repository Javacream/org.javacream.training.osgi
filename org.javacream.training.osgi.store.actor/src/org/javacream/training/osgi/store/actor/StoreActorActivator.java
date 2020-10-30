package org.javacream.training.osgi.store.actor;

import java.util.Collection;

import org.javacream.training.store.api.StoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class StoreActorActivator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Collection<ServiceReference<StoreService>> storeServices = bundleContext.getServiceReferences(StoreService.class, null);
		System.out.println("Available StoreService are:" + storeServices);
		//oder
		Collection<ServiceReference<StoreService>> simpleStoreServices = bundleContext.getServiceReferences(StoreService.class, "(&(type=simple))");
		ServiceReference<StoreService> storeServiceReference = simpleStoreServices.iterator().next();
		StoreService simpleStoreService = bundleContext.getService(storeServiceReference);
		System.out.println(simpleStoreService.getStock("this", "that"));
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
	}

}
