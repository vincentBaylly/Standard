package org.standard.bestpratice.util;

import java.util.ArrayList;
import java.util.List;

import org.standard.bestpratice.bean.AppointmentPrefTO;
import org.standard.bestpratice.bean.ContactDataTO;
import org.standard.bestpratice.bean.ContactPrefTO;

public final class PrefFactory {
	
	private static PrefFactory prefFactory;
	
	private PrefFactory(){
		super();
	}
	
	public static PrefFactory getInstance(){
		if(prefFactory == null){
			prefFactory = new PrefFactory();
		}
		return prefFactory;
	}
	
	public List<ContactDataTO> getListContactData() {

		List<ContactDataTO> contactDataTOs = new ArrayList<ContactDataTO>();

		ContactDataTO contactDataTO1 = new ContactDataTO();
		contactDataTO1.setContactType("PHONE1");
		contactDataTOs.add(contactDataTO1);

		ContactDataTO contactDataTO2 = new ContactDataTO();
		contactDataTO2.setContactType("PHONE2");
		contactDataTOs.add(contactDataTO2);

		ContactDataTO contactDataTO3 = new ContactDataTO();
		contactDataTO3.setContactType("EMAIL1");
		contactDataTOs.add(contactDataTO3);

		return contactDataTOs;
	}
	
	public List<ContactPrefTO> getListContactPref() {

		List<ContactPrefTO> contactPrefTOs = new ArrayList<ContactPrefTO>();

		ContactPrefTO contactPrefTO1 = new ContactPrefTO();
		contactPrefTO1.setContactMethodId("TEXT");
		contactPrefTO1.setContactDataValue("7531980642");
		contactPrefTOs.add(contactPrefTO1);

		ContactPrefTO contactPrefTO2 = new ContactPrefTO();
		contactPrefTO2.setContactMethodId("PHONE");
		contactPrefTO2.setContactDataValue("7531980642");
		contactPrefTOs.add(contactPrefTO2);

		ContactPrefTO contactPrefTO3 = new ContactPrefTO();
		contactPrefTO3.setContactMethodId("EMAIL");
		contactPrefTO3.setContactDataValue("khaisir.williams@gmail.com");
		contactPrefTOs.add(contactPrefTO3);

		return contactPrefTOs;
	}

	public List<AppointmentPrefTO> getListAppointmentPref() {

		List<AppointmentPrefTO> appointPrefTOs = new ArrayList<AppointmentPrefTO>();

		AppointmentPrefTO appointPrefTO1 = new AppointmentPrefTO();
		appointPrefTO1.setContactType("TEXT");
		appointPrefTO1.setContactValue("3147641005");
		appointPrefTOs.add(appointPrefTO1);

		// AppointmentPrefTO appointPrefTO2 = new AppointmentPrefTO();
		// appointPrefTO2.setContactType("PHONE");
		// appointPrefTO2.setContactValue("7202068483");
		// appointPrefTOs.add(appointPrefTO2);

		AppointmentPrefTO appointPrefTO3 = new AppointmentPrefTO();
		appointPrefTO3.setContactType("EMAIL");
		appointPrefTO3.setContactValue("john.doe@example.com");
		appointPrefTOs.add(appointPrefTO3);

		return appointPrefTOs;

	}
	
}
