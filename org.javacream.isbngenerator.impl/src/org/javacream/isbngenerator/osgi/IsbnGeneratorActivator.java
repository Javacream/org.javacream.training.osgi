package org.javacream.isbngenerator.osgi;

import java.util.Dictionary;
import java.util.Hashtable;

import org.javacream.isbngenerator.IsbnGenerator;
import org.javacream.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.isbngenerator.impl.SequenceIsbnGenerator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class IsbnGeneratorActivator implements BundleActivator {

	private ServiceRegistration<IsbnGenerator> serviceReferenceRandom;
	private ServiceRegistration<IsbnGenerator> serviceReferenceSequence;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator();
		Dictionary<String, String> typeRandom = new Hashtable<String, String>();
		typeRandom.put("type", "random");
		SequenceIsbnGenerator sequenceIsbnGenerator = new SequenceIsbnGenerator();
		Dictionary<String, String> typeSequence = new Hashtable<String, String>();
		typeSequence.put("type", "sequence");
		serviceReferenceRandom = bundleContext.registerService(IsbnGenerator.class, randomIsbnGenerator, typeRandom);
		serviceReferenceSequence = bundleContext.registerService(IsbnGenerator.class, sequenceIsbnGenerator, typeSequence);
		System.out.println("registering services done");
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		serviceReferenceRandom.unregister();
		serviceReferenceSequence.unregister();
	}

}
