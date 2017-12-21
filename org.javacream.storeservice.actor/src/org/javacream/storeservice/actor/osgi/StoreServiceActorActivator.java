package org.javacream.storeservice.actor.osgi;

import org.javacream.storeservice.api.StoreService;
import org.javacream.storeservice.actor.StoreServiceActor;
import org.javacream.storeservice.impl.BooksStoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
public class StoreServiceActorActivator implements BundleActivator{

	private StoreServiceActor actor;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		actor = new StoreServiceActor();
		
		StoreService storeService = new BooksStoreService();
		actor.setStoreService(storeService);
		actor.startup();
		
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		actor.finish();
	}

}
