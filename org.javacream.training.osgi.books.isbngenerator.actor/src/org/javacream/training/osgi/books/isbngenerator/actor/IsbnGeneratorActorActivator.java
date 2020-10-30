package org.javacream.training.osgi.books.isbngenerator.actor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.javacream.books.isbngenerator.IsbnGenerator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class IsbnGeneratorActorActivator implements BundleActivator{

	private ScheduledExecutorService executorService;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting...");
		
		IsbnGenerator isbnGenerator = bundleContext.getService(bundleContext.getServiceReferences(IsbnGenerator.class, null).iterator().next());
		System.out.println(isbnGenerator.getClass().getName());
		executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(() -> System.out.println(isbnGenerator.next()), 0, 5, TimeUnit.SECONDS);
		isbnGenerator.getClass().getMethod("setPrefix", String.class).invoke(isbnGenerator, "Reflection");
		//Class.forName("org.javacream.books.isbngenerator.impl.RandomIsbnGenerator"); //ClassNotFoundException
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		System.out.println("Stopping...");
		executorService.shutdownNow();
	}

}
