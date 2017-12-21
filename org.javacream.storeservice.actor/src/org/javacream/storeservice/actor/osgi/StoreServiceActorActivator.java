package org.javacream.storeservice.actor.osgi;

import org.javacream.storeservice.actor.StoreServiceActor;
import org.javacream.storeservice.api.StoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
public class StoreServiceActorActivator implements BundleActivator{

	private StoreServiceActor actor;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		actor = new StoreServiceActor();
		Filter filter = bundleContext.createFilter("(&(objectClass=org.javacream.storeservice.api.StoreService)(type=dvd))");
		ServiceTracker<StoreService, StoreService> storeServiceTracker = new ServiceTracker<StoreService, StoreService>(bundleContext, filter, null);
		storeServiceTracker.open();
		StoreServiceProxy proxy = new StoreServiceProxy();
		proxy.setStoreServiceTracker(storeServiceTracker);
		actor.setStoreService(proxy);
		actor.startup();
		
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		actor.finish();
	}

}
