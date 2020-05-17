package org.initial.exception;

import java.util.logging.Logger;

public class TestErrorEntryException {
	
	private static final Logger LOG = Logger.getLogger("TestErrorEntryException.class");
	
	public static void main(java.lang.String[] args) {
		String string1 = "bonjour";
		String string2 = "";
		
		try {
			control(string1);
		} catch (ErrorEntryException e) {
			System.out.println("Chaine2 saisie erronee");
		}finally {
			
		}
		
		try {
			control(string2);
		} catch (ErrorEntryException e) {
			LOG.severe("Chaine2 saisie erronee");
		}catch(Exception npe) {
		
		}finally {
			
		}
		
		
	}
	
	public static void control(String string) throws ErrorEntryException {
		if (string.equals("") == true)
			throw new ErrorEntryException("Saisie erronee : chaine vide");
	}

}
