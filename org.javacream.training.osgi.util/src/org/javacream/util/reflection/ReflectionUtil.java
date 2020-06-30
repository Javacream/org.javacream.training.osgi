package org.javacream.util.reflection;

import org.osgi.framework.FrameworkUtil;

public class ReflectionUtil {

	
	public static String loadClass(String name){
		try {
			FrameworkUtil.getBundle(ReflectionUtil.class).loadClass(name);
			return "loaded class " + name;
		} catch (ClassNotFoundException e) {
			return "unable to load class " + name;
		}
	}
	public static Class<?> getClass(String name){
		try {
			return FrameworkUtil.getBundle(ReflectionUtil.class).loadClass(name);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	public static Object getObjectFrom(String name){
		try {
			return FrameworkUtil.getBundle(ReflectionUtil.class).loadClass(name).newInstance();
		} catch (Exception e) {
			return null;
		}
	}
}
