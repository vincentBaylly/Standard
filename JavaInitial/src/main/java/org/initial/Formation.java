package org.initial;

import java.util.logging.Logger;

import org.initial.heritage.IEmployee;
import org.initial.io.XMLParser;

/**
 * DocBlock
 * 
 * @author vincent.baylly
 *
 */
@SuppressWarnings("unused")
public class Formation {
	
	private static final Logger LOG = Logger.getLogger("Formation.class");
	
	/**
	 * Docblock on a method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// comment line
		System.out.println("Bonjour étudiants!!!");// comment at the end of a line
		LOG.info("test configuration");
		LOG.severe("test configuration");
		
		XMLParser.parseXmlFile("src/main/resources/catalogue.xml");
	}

	public static void someInstruction() {
		System.out.println(1 + 1);

		System.out.println(true && false);

		String string = "Hello";

		string = "Bye" + "bye";
	}

	public static void condition() {
		
		//if else condition
		int i = 0;
		if (i < 0) {
			System.out.println("Ce nombre est négatif !");
		} else {
			if (i == 0)
				System.out.println("Ce nombre est nul !");

			else
				System.out.println("Ce nombre est positif !");

		}
		
		//switch case declaration
		String inMyswitch = "true";
		switch (inMyswitch)
		{
		  case "true" /*Argument*/:
		    /*Action*/;
		    break;        
		  default:
		    /*Action*/;             
		}
		
		//condition ternaire
		int x = 10, y = 20;
		int max = (x < y) ? y : x ; //Maintenant, max vaut 20

	}
	
	public static void arrayDeclaration() {
		
		int arrayIntegerFilled[] = {0,1,2,3,4,5,6,7,8,9};
		double arrayDouble[] = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
		char arrayChar[] = {'a','b','c','d','e','f','g'};
		String arrayString[] = {"chaine1", "chaine2", "chaine3" , "chaine4"};
		
		int arrayIntEmpty[] = new int[6];
		//Or
		int[] arrayIntEmpty2 = new int[6];
		
		//multidimension
		int firstNumberPairImpair[][] = { {0,2,4,6,8},{1,3,5,7,9} };
	}
	
	public static void loopTypes() {
		
	}
	
	public static double round(double A, int B) {
	  return (double) ( (int) (A * Math.pow(10, B) + .5)) / Math.pow(10, B);
	}
	
	public static double harmonic(int n) {
		double sum = 0.0;
		for(int i = 1; i <= n; i++)
			sum += 1.0/i;
		return sum;
	}
	
	public static double getEmployeeSalary(IEmployee employee) {
		return employee.getSalary();
	}
	
	/**
	 * Without interface will have to write a different method get salary
	 * with all type of Employe in parameter
	 * 
	 */
//	public static double getEmployeeSalary(Teacher teacher) {
//		return teacher.getSalary();
//	}
	
//	public static double getEmployeeSalary(Plumber plumber) {
//		return plumber.getSalary();
//	}
	
}
