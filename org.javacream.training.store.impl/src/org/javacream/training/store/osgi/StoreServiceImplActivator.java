package org.javacream.training.store.osgi;

import java.util.Dictionary;
import java.util.Hashtable;

import org.javacream.training.store.api.StoreService;
import org.javacream.training.store.impl.SimpleStoreService;
import org.javacream.training.store.impl.VerySimpleStoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class StoreServiceImplActivator implements BundleActivator {

	private ServiceRegistration<StoreService> serviceRegistrationForSimple;
	private ServiceRegistration<StoreService> serviceRegistrationForVerySimple;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		SimpleStoreService simpleStoreService = new SimpleStoreService();
		Dictionary<String, String> filterForSimpleStoreService = new Hashtable<>();
		filterForSimpleStoreService.put("type", "simple");
		VerySimpleStoreService verySimpleStoreService = new VerySimpleStoreService();
		Dictionary<String, String> filterForVerySimpleStoreService = new Hashtable<>();
		filterForVerySimpleStoreService.put("type", "very_simple");
		
		serviceRegistrationForSimple = bundleContext.registerService(StoreService.class, simpleStoreService, filterForSimpleStoreService);
		serviceRegistrationForVerySimple = bundleContext.registerService(StoreService.class, verySimpleStoreService, filterForVerySimpleStoreService);
		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		serviceRegistrationForSimple.unregister();
		serviceRegistrationForVerySimple.unregister();
		
	}

}
