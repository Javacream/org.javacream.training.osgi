package org.javacream.training.osgi.util.test;

import org.javacream.util.reflection.ReflectionUtil;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public void start(BundleContext bundleContext) throws Exception {
		final String ID_GENERATOR_CLASS = "org.javacream.training.util.id.IdGenerator";
		final String RANDOM_ID_GENERATOR_CLASS = "org.javacream.training.util.id.impl.RandomIdGenerator";
		final String CLASS_FROM_OWN_BUNDLE = "org.javacream.training.osgi.util.test.Simple";
		final String GREETER_CLASS = "org.javacream.training.osgi.greeter.SimpleGreeter";
		System.out.println(ReflectionUtil.loadClass(ID_GENERATOR_CLASS));
		System.out.println(ReflectionUtil.getClass(ID_GENERATOR_CLASS));
		System.out.println(ReflectionUtil.loadClass(RANDOM_ID_GENERATOR_CLASS));
		System.out.println(ReflectionUtil.getClass(RANDOM_ID_GENERATOR_CLASS));
		System.out.println(ReflectionUtil.loadClass(CLASS_FROM_OWN_BUNDLE));
		System.out.println(ReflectionUtil.getClass(CLASS_FROM_OWN_BUNDLE));
		System.out.println(ReflectionUtil.loadClass(GREETER_CLASS));
		System.out.println(ReflectionUtil.getClass(GREETER_CLASS));
		System.out.println(ReflectionUtil.getObjectFrom(RANDOM_ID_GENERATOR_CLASS));
		System.out.println(ReflectionUtil.getObjectFrom(GREETER_CLASS));
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
	}

}
