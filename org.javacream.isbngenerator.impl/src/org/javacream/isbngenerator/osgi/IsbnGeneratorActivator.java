package org.javacream.isbngenerator.osgi;

import org.javacream.isbngenerator.IsbnGeneratorFactory;
import org.javacream.isbngenerator.impl.DefaultIsbnGenerator;
import org.javacream.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.isbngenerator.impl.SequenceIsbnGenerator;
import org.javacream.isbngenerator.impl.SystemTimeIsbnGenerator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class IsbnGeneratorActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		String strategy = bundleContext.getBundle().getHeaders()
				.get("IsbnGeneratorStrategy");
		if (strategy == null) {
			IsbnGeneratorFactory.isbnGenerator = new DefaultIsbnGenerator();
		} else {
			switch (strategy) {
			case "systemtime":
				IsbnGeneratorFactory.isbnGenerator = new SystemTimeIsbnGenerator();
				break;
			case "sequence":
				IsbnGeneratorFactory.isbnGenerator = new SequenceIsbnGenerator();
				break;
			case "random":
				IsbnGeneratorFactory.isbnGenerator = new RandomIsbnGenerator();
				break;
			default:
				IsbnGeneratorFactory.isbnGenerator = new DefaultIsbnGenerator();
			}
		}
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {

	}

}
