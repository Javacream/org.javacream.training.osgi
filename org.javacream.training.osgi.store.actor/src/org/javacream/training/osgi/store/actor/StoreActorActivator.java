package org.javacream.training.osgi.store.actor;

import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.javacream.training.store.api.StoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class StoreActorActivator implements BundleActivator {

	private ScheduledExecutorService executorService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		executorService = Executors.newSingleThreadScheduledExecutor();
		Filter filter = bundleContext.createFilter("(&(objectClass=" + StoreService.class.getName() + ")&(type=simple))");
		ServiceTracker<StoreService, StoreService> storeServiceTracker = new ServiceTracker<>(bundleContext, filter, null);
		storeServiceTracker.open();
		executorService.scheduleAtFixedRate(() -> {
			StoreService simpleStoreService;
			try {
				simpleStoreService = storeServiceTracker.waitForService(5000);
				System.out.println(simpleStoreService.getStock("this", "that"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, 0, 5, TimeUnit.SECONDS);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		executorService.shutdown();
	}

}
