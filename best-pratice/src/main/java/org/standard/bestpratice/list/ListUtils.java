package org.standard.bestpratice.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.standard.bestpratice.bean.ContactDataTO;
import org.standard.bestpratice.bean.ContactPrefTO;
import org.standard.bestpratice.bean.SimpleBean;
import org.standard.bestpratice.util.PrefFactory;


public class ListUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ListUtils.class);
    private static final PrefFactory prefFactory = PrefFactory.getInstance();

    public void removeItemInList() {

        List<ContactPrefTO> contactPrefTOs = prefFactory.getListContactPref();
        List<ContactPrefTO> contactPrefToDelete = new ArrayList<ContactPrefTO>();
        for (ContactPrefTO contactPrefTO : contactPrefTOs) {
            contactPrefToDelete.add(contactPrefTO);
        }
        LOG.debug("List to save " + StringUtils.join(contactPrefTOs, ""));

        for (final ContactPrefTO contactPrefTO : contactPrefTOs) {
            contactPrefToDelete.remove(contactPrefTO);
            LOG.debug("List to save " + StringUtils.join(contactPrefToDelete, ""));
            LOG.debug("has been removed");
        }

    }

    public void findLastDigit() {

        List<ContactDataTO> contactDataTOs = prefFactory.getListContactData();

        final Map<String, Integer> contactLastIdMap = new HashMap<String, Integer>();

        for (ContactDataTO contactDataTO : contactDataTOs) {

            int stringLength = contactDataTO.getContactType().length();

            for (int i = 0; i < stringLength; i++) {
                if (Character.isDigit(contactDataTO.getContactType().charAt(i))) {

                    String contactType = contactDataTO.getContactType().substring(0, i);
                    Integer nextId = Integer.parseInt(contactDataTO.getContactType().substring(i, stringLength));

                    contactLastIdMap.put(contactType, nextId);
                    break;
                }
            }
        }

        Set<String> cles = contactLastIdMap.keySet();
        Iterator<String> it = cles.iterator();
        while (it.hasNext()) {
            String cle = it.next();
            LOG.debug("contact Type : " + cle + " next ID : " + contactLastIdMap.get(cle));
        }

    }

    public void sort() {

        List<SimpleBean> beans = new ArrayList<SimpleBean>();

        SimpleBean bean1 = new SimpleBean();
        bean1.setId(1);
        bean1.setName("custgrp5112");

        SimpleBean bean3 = new SimpleBean();
        bean3.setId(3);
        bean3.setName("custgrp5012");

        SimpleBean bean2 = new SimpleBean();
        bean2.setId(2);
        bean2.setName("custgrp7540");

        beans.add(bean1);
        beans.add(bean3);
        beans.add(bean2);

        CompareList compList = new CompareList();

        Collections.sort(beans, compList);

        LOG.debug(beans.toString());

        for (SimpleBean bean : beans) {
            LOG.debug(bean.toString());
        }

    }

    public void concatList() {
        List<String> array = new ArrayList<String>();
        List<String> array2 = new ArrayList<String>();
        array2.add("test2");
        array2.add("test3");
        array.add("test1");
        array.addAll(array2);

        LOG.debug(array.toString());
    }

    public void compareToList() {

        List<String> array = new ArrayList<String>();
        array.add("test1");
        array.add("test2");
        array.add("test3");

        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 1; j < array.size(); j++) {
                if (i == j) {
                    continue;
                }
                LOG.debug("i: " + array.get(i));
                LOG.debug("j: " + array.get(j));
            }
        }

    }

}
