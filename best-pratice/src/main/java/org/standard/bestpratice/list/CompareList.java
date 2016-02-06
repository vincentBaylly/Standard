package org.standard.bestpratice.list;

import java.util.Comparator;

import org.standard.bestpratice.bean.SimpleBean;

public class CompareList implements Comparator<SimpleBean> {

	@Override
	public int compare(SimpleBean bean1, SimpleBean bean2) {
		return bean1.getName().compareTo(bean2.getName());
	}

}
