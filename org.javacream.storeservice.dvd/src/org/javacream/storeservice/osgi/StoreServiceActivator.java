package org.javacream.storeservice.osgi;

import java.util.Dictionary;
import java.util.Hashtable;

import org.javacream.storeservice.api.StoreService;
import org.javacream.storeservice.impl.DvdStoreService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class StoreServiceActivator implements BundleActivator {

	private ServiceRegistration<StoreService> serviceReference;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		DvdStoreService booksStoreService = new DvdStoreService();
		Dictionary<String, String> type = new Hashtable<String, String>();
		type.put("type", "dvd");
		serviceReference = bundleContext.registerService(StoreService.class, booksStoreService, type);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		serviceReference.unregister();
	}

}
