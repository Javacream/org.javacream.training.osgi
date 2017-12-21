package org.javacream.training.osgi.greeter.actor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.javacream.training.osgi.greeter.SimpleGreeter;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private ScheduledExecutorService scheduledExecutorService;

	public void start(BundleContext bundleContext) throws Exception {
		scheduledExecutorService = Executors.newScheduledThreadPool(1);
		SimpleGreeter simpleGreeter = new SimpleGreeter();
		scheduledExecutorService.scheduleAtFixedRate( () ->
				System.out.println(simpleGreeter.greet("Hugo"))
		, 0, 5, TimeUnit.SECONDS);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		scheduledExecutorService.shutdown();
	}

}
