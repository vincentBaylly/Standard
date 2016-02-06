package org.standard.bestpratice.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.standard.bestpratice.bean.AppointmentPrefTO;
import org.standard.bestpratice.bean.ContactPrefTO;
import org.standard.bestpratice.bean.SimpleBean;

public class ListUtils {

	private static final Logger LOG = LoggerFactory.getLogger(ListUtils.class);
	private static PrefFactory prefFactory = PrefFactory.getInstance();
	
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

	public void saveContactData2() {

		List<ContactPrefTO> listToSave = new ArrayList<ContactPrefTO>();

		for (final AppointmentPrefTO appointmentPrefTO : PrefFactory.getInstance().getListAppointmentPref()) {
			ContactPrefTO cptoEquivalent = null;
			for (final ContactPrefTO contactPrefTO : prefFactory.getListContactPref()) {
				if (contactPrefTO.getContactDataValue().equals(appointmentPrefTO.getContactValue())) {
					cptoEquivalent = contactPrefTO;
					break;
				}
			}

			// if its a new item : so we have to addIt an create it
			if (cptoEquivalent == null) {
				ContactPrefTO contactPrefTOToSave = new ContactPrefTO();
				contactPrefTOToSave.setContactMethodId(appointmentPrefTO.getContactType());
				contactPrefTOToSave.setContactDataValue(appointmentPrefTO.getContactValue());
				listToSave.add(contactPrefTOToSave);
			}
			// We have found an equivalent for the one from the user
			else {
				// if the method differ, we have to check what we do with it
				if (!cptoEquivalent.getContactMethodId().equals(appointmentPrefTO.getContactType())) {

					// If the cpto is phone and the apto is text

					// if the cpto is text and the apto is phone

					// if hte cpto is mail and apto is phone

					// if hte cpto is mail and apto is text

					// if hte cpto is text and apto is mail

					// if hte cpto is phone and apto is mail

				}
				// else implicit: do nothing with this cause we dont want to
				// save it
			}
		}

		LOG.debug("List to save " + StringUtils.join(listToSave, " | "));

	}

	public void saveContactData() {

		List<ContactPrefTO> listToSave = new ArrayList<ContactPrefTO>();

		for (final AppointmentPrefTO appointmentPrefTO : prefFactory.getListAppointmentPref()) {
			for (final ContactPrefTO contactPrefTO : prefFactory.getListContactPref()) {
				if (contactPrefTO.getContactMethodId().equals(appointmentPrefTO.getContactType())) {
					if (!contactPrefTO.getContactDataValue().equals(appointmentPrefTO.getContactValue())) {

						ContactPrefTO contactPrefTOToSave = new ContactPrefTO();
						contactPrefTOToSave.setContactMethodId(appointmentPrefTO.getContactType());
						contactPrefTOToSave.setContactDataValue(appointmentPrefTO.getContactValue());
						listToSave.add(contactPrefTOToSave);
					}
				} else {
					// PHONE TO TEXT with same number
					// Change the contact data with sms capable
					// Add contact preference with the text method and the
					// appointment service

					// TEXT TO PHONE with same number
					// Add contact preference with the text method and the
					// appointment service
				}
			}
		}

		LOG.debug("List to save " + StringUtils.join(listToSave, " | "));
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

}
