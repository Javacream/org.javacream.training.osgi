package org.javacream.isbngenerator.actor.osgi;

import org.javacream.isbngenerator.actor.IsbnGeneratorActor;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class IsbnGeneratorActorActivator implements BundleActivator{

	private IsbnGeneratorActor actor;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		actor = new IsbnGeneratorActor();
		actor.startup();
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		actor.finish();
	}

}
