package org.javacream.training.osgi.util.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;

public class Activator implements BundleActivator {

	private BundleListener bundleListener;
	public void start(BundleContext bundleContext) throws Exception {
		bundleListener = new SimpleBundleListener();
		bundleContext.addBundleListener(bundleListener);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.removeBundleListener(bundleListener);
	}
	
	private class SimpleBundleListener implements BundleListener{

		@Override
		public void bundleChanged(BundleEvent bundleEvent) {
			System.out.println(bundleEvent);
		}
		
	}

}
