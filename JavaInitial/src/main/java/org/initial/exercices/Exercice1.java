package org.initial.exercices;

import java.util.logging.Logger;

import org.initial.heritage.IEmployee;
import org.initial.heritage.Student;
import org.initial.heritage.Teacher;

public class Exercice1 {
	
	private static final Logger LOG = Logger.getLogger("Exercice1.class");
	
    public static void main (String[] args) {
        System.out.println("Bienvenue dans cette formation Java");
        LOG.info("Bienvenue dans cette formation Java");
        
        Student person = new Student();
        
        person.setFirstName("Julien");
        person.setStudentNumber(12345);
        
        Teacher teacher = new Teacher();
        getEmployeeSalary(teacher);
        
        System.out.print("Je m'appel ");
        System.out.print(person.getFirstName());
    }
    
    public static double getEmployeeSalary(IEmployee employee) {
    	return employee.getSalary();
    }
    
    
    
}
