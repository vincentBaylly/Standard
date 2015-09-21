package org.standard.bestpratice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.standard.bestpratice.bean.SimpleBean;
import org.standard.bestpratice.io.FileHandling;
import org.standard.bestpratice.reflect.Reflexion;
import org.standard.bestpratice.serialize.Serializer;
import org.standard.bestpratice.util.CompareList;

public class Runner {

	private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

	public static void main(String[] args) {
		
		LOG.debug("Run fun stuff to be sure we are able to comput in Java");
		
		List<SimpleBean> beans = new ArrayList<SimpleBean>();
		
		SimpleBean bean1 = new SimpleBean();
		bean1.setId(1);
		bean1.setName("bean1");
		
		SimpleBean bean3 = new SimpleBean();
		bean3.setId(3);
		bean3.setName("bean3");
		
		SimpleBean bean2 = new SimpleBean();
		bean2.setId(2);
		bean2.setName("bean2");
		
		beans.add(bean1);
		beans.add(bean3);
		beans.add(bean2);
		
		CompareList compList = new CompareList();
		
		Collections.sort(beans, compList);
		
		for(SimpleBean bean : beans){
			LOG.debug(bean.toString());
		}
		
		LOG.debug("We did it right, we can now use it in our code ");

	}

	public void toBeOrNotToBeReflected() {

		Reflexion reflexion = new Reflexion();
		reflexion.reflect();
		
	}

	public void serializeUnSerialize() {

		Serializer serializer = new Serializer();
		serializer.serialize();

		FileHandling fileHandling = new FileHandling();
		fileHandling.writeInPropertiesFile();
		fileHandling.readInPropertiesFile();

	}

}