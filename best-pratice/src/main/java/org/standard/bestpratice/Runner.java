package org.standard.bestpratice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.codec.binary.Base64;
import org.jasypt.digest.StandardStringDigester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.standard.bestpratice.bean.ContactDataTO;
import org.standard.bestpratice.io.FileHandling;
import org.standard.bestpratice.reflect.Reflexion;
import org.standard.bestpratice.serialize.Serializer;
import org.standard.bestpratice.util.PrefFactory;

public class Runner {

	private static final Logger LOG = LoggerFactory.getLogger(Runner.class);
	
	private static Integer existingId = 1;
	
	public static void main(String[] args) {
	
		LOG.debug("Run fun stuff to be sure we are able to comput in Java");
        
//		List<String> array = new ArrayList<String>();
//		array.add("test1");
//		array.add("test2");
//		array.add("test3");
//
//		
//		for(int i = 0 ; i < array.size() - 1; i++ ){
//			for(int j = 1 ; j < array.size(); j++ ){
//				if(i == j) {
//                    continue;
//                }
//				LOG.debug("i: " + array.get(i));
//				LOG.debug("j: " + array.get(j));
//			}
//		}
		
		String phoneIdI = "0P2";
		String phoneIdJ = "0P1";
		
		if(Integer.parseInt(phoneIdI.replaceAll("[\\D]", "")) > Integer.parseInt(phoneIdJ.replaceAll("[\\D]", ""))){
			LOG.debug("Integer " + Integer.parseInt(phoneIdI.replaceAll("[\\D]", "")));
		}
        
		
		//test();
//		try {
//			
//			final GregorianCalendar now = (GregorianCalendar)GregorianCalendar.getInstance();
//			
//			DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
//			XMLGregorianCalendar xmlStartTime = dataTypeFactory.newXMLGregorianCalendar(now);
//			xmlStartTime.setTimezone(0);
//			System.out.println(xmlStartTime.toString());
//			
//			now.add(Calendar.MINUTE, 1);
//			
//			XMLGregorianCalendar xmlStartTime1Minute = dataTypeFactory.newXMLGregorianCalendar(now);
//			xmlStartTime1Minute.setTimezone(0);
//			System.out.println(xmlStartTime1Minute.toString());
//
//		} catch (DatatypeConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		LOG.debug("We did it right, we can now use it in our code ");
	}
	
	public static Calendar convertToGmt(Calendar cal) {

		Date date = cal.getTime();
		TimeZone tz = cal.getTimeZone();

		LOG.debug("input calendar has date [" + date + "]");

		//Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT 
		long msFromEpochGmt = date.getTime();

		//gives you the current offset in ms from GMT at the current date
		int offsetFromUTC = tz.getOffset(msFromEpochGmt);
		LOG.debug("offset is " + offsetFromUTC);

		//create a new calendar in GMT timezone, set to this date and add the offset
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.setTime(date);
		gmtCal.add(Calendar.MILLISECOND, offsetFromUTC);

		LOG.debug("Created GMT cal with date [" + gmtCal.getTime() + "]");

		return gmtCal;
	}
	
	public static Calendar convertCalendar(final Calendar calendar, final TimeZone timeZone) {
	    Calendar ret = new GregorianCalendar(timeZone);
	    ret.setTimeInMillis(calendar.getTimeInMillis() +
	            timeZone.getOffset(calendar.getTimeInMillis()) -
	            TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
	    ret.getTime();
	    return ret;
	}
	
	private static void test(){

		int id = 1;
        if (existingId != null) {
            id = existingId + 1;
        }
        final String nextId = "E" + id++;
        existingId = id;
        
        LOG.debug("id : " + id);
        LOG.debug("nextId : " + existingId);
		
        LOG.debug("contactType : " + nextId);
        
		final Calendar now = convertCalendar(Calendar.getInstance(), TimeZone.getTimeZone("Etc/Zulu"));
		
		List<String> array = new ArrayList<String>();
		List<String> array2 = new ArrayList<String>();
		array2.add("test2");
		array2.add("test3");
		array.add("test1");
		array.addAll(array2);
		
		LOG.debug(array.toString());
		
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'");
//        format.setTimeZone(TimeZone.getTimeZone("UTC"));
//        format.se
        String dateNow = format.format(now.getTime());
        
        now.add(Calendar.SECOND, 1);

        String dateNow1Second = format.format(now.getTime());
        
        LOG.debug("now : " + dateNow);
        LOG.debug("now1Second : " + dateNow1Second);
        
        StandardStringDigester digester = new StandardStringDigester();
        digester.setAlgorithm("SHA-1");   // optionally set the algorithm
        digester.setIterations(2500);
        digester.setSaltSizeBytes(8);
        String digest = digester.digest("9s_X$3Bo6");
        
        encodeRampartNonce();
        
        LOG.debug("password : " + digest);
        
        LOG.debug("random Id " + getSaltString());
	}
	
	private static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 32) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	private static void encodeRampartNonce(){
		Random random = null;
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(System.currentTimeMillis());
        } catch (final NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        final byte[] r = new byte[16];
        random.nextBytes(r);
        String nonceBase64 = Base64.encodeBase64String(r);
		
        LOG.debug(r.toString());
        nonceBase64 = nonceBase64.replaceAll("[\r\n]+", "");
        LOG.debug(nonceBase64);
        LOG.debug("saut de ligne");
		//dHxHn8NcEjzaQ4KQX6j27Q==
        //ZlMIni/fEyY4qpBCJXAIxQ==
        //tAzmLb8dbvHtHARq1EF5OQ==
        //0BoFd08zqh1z8htR9WqtrUCayXY=
	}
	
	private static void createInputStream(){
		InputStream resource = null;
		
        try {
            resource =
                    new FileInputStream("src/main/resources/policy.xml");
            final BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
            final StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            LOG.debug("input policy : " + out.toString());

        } catch (final Exception e) {
        	LOG.error(e.toString());
        }
	}
	
    private static void readInputStream(final InputStream resource) throws Exception {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
        final StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        LOG.debug("input policy : " + out.toString());
        reader.close();
    }
	
	public void findLastDigit(){
		
		PrefFactory prefFactory = PrefFactory.getInstance();

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
	public void increment() {

		int i = 0;
		int j = 1;

		LOG.debug("i: " + ++i + " j: " + j++);
		LOG.debug("i : " + i + " j: " + j);
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
	
	public void marchallingUmarshalling(){
    try {

        final JAXBContext jaxbContext = JAXBContext.newInstance("com.charter.enterprise.prefcomm.v1");
        final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

//        final JAXBElement<SaveContactDatasByValuesListResponse> test =
//                (JAXBElement<SaveContactDatasByValuesListResponse>) unmarshaller.unmarshal(new File(
//                        "saveContactDatasByValuesListResponse.xml"));

//        System.out.println("contact ID " + test.getValue().getReturn().get(0).getContact().getId());

        // Marshal the employees list in console
//        jaxbMarshaller.marshal(test, System.out);

    } catch (final JAXBException e) {
        e.printStackTrace();
    }
	}

}