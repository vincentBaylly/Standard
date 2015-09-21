package org.standard.bestpratice.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleBean {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleBean.class);
	
	private int id;
	
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected void calculateSuccessURL(String toDisplay) {
		LOG.debug("You introspect me baby! " + toDisplay);
	 }
	
	@Override
	public String toString(){
		
		StringBuilder beanValue = new StringBuilder();
		beanValue.append("the bean Id : " + this.getId());
		beanValue.append("the bean Name : " + this.getName());
		
		return beanValue.toString();
	}
}
