package org.initial.exercices.exercice9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.initial.heritage.Person;
import org.initial.heritage.Teacher;

public class PersonsManager {

	private static final Logger LOG = Logger.getLogger("TestErrorEntryException.class");

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		Teacher teacher1 = new Teacher();
		persons.add(teacher1);
		teacher1.setFirstName("Yves");
		teacher1.setLastName("LOCOSO");
		persons.add(new Teacher("Jean-françois", "BERTRAND"));
		persons.add(new Teacher("Martin", "LECLERC"));
		persons.add(new Teacher("Mohamed", "AMINE"));
		
		//we can add a child class of Person in the list like Student
		//persons.add(new Student());
		
		//but because we specifying a type <Person> as the generic declaration contain by the list
		//we can add any element other class type
		//persons.add(new Student());//will not compile
		
		LOG.info("Avant le tri : ");
		for (Person person : persons)
			LOG.info("\t" + person);

		Collections.sort(persons);

		LOG.info("Après le tri : ");
		for (Person person : persons)
			LOG.info("\t" + person);
	}
}
