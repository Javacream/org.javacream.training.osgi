package org.javacream.storeservice.actor.osgi;

import java.util.Collection;

import org.javacream.storeservice.actor.StoreServiceActor;
import org.javacream.storeservice.api.StoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
public class StoreServiceActorActivator implements BundleActivator{

	private StoreServiceActor actor;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		Collection<ServiceReference<StoreService>> storeServiceReferences = bundleContext.getServiceReferences(StoreService.class, null);
		System.out.println("Available StoreServices are:");
		for (ServiceReference<StoreService> storeServiceReference: storeServiceReferences){
			System.out.println("\t type=" + storeServiceReference.getProperty("type"));
		}
		Collection<ServiceReference<StoreService>> references = bundleContext.getServiceReferences(StoreService.class, "(&(type=book))");
		StoreService storeService = bundleContext.getService(references.iterator().next());
		actor = new StoreServiceActor();
		actor.setStoreService(storeService);
		actor.startup();
		
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		actor.finish();
	}

}
