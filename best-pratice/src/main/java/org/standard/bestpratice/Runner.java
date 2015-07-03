package org.standard.bestpratice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.standard.bestpratice.io.FileHandling;
import org.standard.bestpratice.reflect.Reflexion;
import org.standard.bestpratice.serialize.Serializer;


public class Runner {
	
	private static final Logger LOG = LoggerFactory.getLogger(Runner.class);
	
	public static void main(String[] args) {
		
		LOG.info("Run fun stuff to be sure we are able to comput in Java");
		
		Reflexion reflexion = new Reflexion();
		reflexion.reflect();
		
		Serializer serializer = new Serializer();
		serializer.serialize();
		
		FileHandling fileHandling = new FileHandling();
		fileHandling.writeInPropertiesFile();
		fileHandling.readInPropertiesFile();
		
		LOG.info("We did it right, we can now use it in our code");
	}
}