package org.standard.bestpratice.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reflexion {
	
	private static final Logger LOG = LoggerFactory.getLogger(Reflexion.class);
	
	public void reflect(){
		
		try {
			
			// with reflection
			Class<?> c = Class.forName("org.standard.bestpratice.bean.SimpleBean");
			Object simpleBean = c.newInstance();
			Method m = c.getDeclaredMethod("calculateSuccessURL", String.class);
			m.setAccessible(true);
			m.invoke(simpleBean, "you right I did it");

		} catch (IllegalAccessException e) {
			LOG.error("error occur during introspection", e);
		} catch (InvocationTargetException e) {
			LOG.error("error occur during introspection", e);
		} catch (ClassNotFoundException e) {
			LOG.error("error occur during introspection", e);
		} catch (InstantiationException e) {
			LOG.error("error occur during introspection", e);
		} catch (SecurityException e) {
			LOG.error("error occur during introspection", e);
		} catch (NoSuchMethodException e) {
			LOG.error("error occur during introspection", e);
		}
	}
}
