package org.initial.poo;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.initial.heritage.Gender;
import org.initial.heritage.Person;
import org.initial.heritage.Teacher;

public class StreamAndLambda {

	public void testLambda() {
		Button myButton = new Button();

		// Avant les lambsa
		myButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("clic");
			}
		});

		/*
		 * Utilisation d'un lambda Dans ce cas, c'est une expression lambda qui est
		 * passée en paramètre. Elle permet de définir une implémentation d'une
		 * interface fonctionnelle sous la forme d'une expression composée d'une liste
		 * de paramètres et d'un corps qui peut être une simple expression ou un bloc de
		 * code. (arguments) -> corps
		 */
		myButton.addActionListener(event -> System.out.println("clic"));
	}

	public void testStream() {

		// iterator
		List<Integer> integer = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		Iterator<Integer> it = integer.iterator();
		long sum = 0;
		while (it.hasNext()) {
			int value = it.next();
			if (value < 10) {
				sum += value;
			}
		}
		System.out.println(sum);

		// simplification du parcours de la liste
		sum = 0;
		for (int value : integer) {
			if (value < 10) {
				sum += value;
			}
		}
		System.out.println(sum);

		LongAdder longAdder = new LongAdder();
		integer.forEach(value -> {
			if (value < 10) {
				longAdder.add(value);
			}
		});
		System.out.println(longAdder);

		// utilisation d'un stream
		sum = integer.stream().filter(v -> v < 10).mapToInt(i -> i).sum();
		System.out.println(sum);

		// les streams peuvent optimiser les performances en executant les operations en
		// parallele
		sum = integer.parallelStream().filter(v -> v < 10).mapToInt(i -> i).sum();
		System.out.println(sum);
	}

	public void operationJavaStandard() {
		List<Person> persons = new ArrayList<>(6);
		persons.add(new Teacher("Ali", "ALAMI", Gender.HOMME, 176));
		persons.add(new Teacher("Mohamed", "AMINE", Gender.HOMME, 190));
		persons.add(new Teacher("CONNOR", "Lara", Gender.FEMME, 172));
		persons.add(new Teacher("BERTRAND", "Virginie", Gender.FEMME, 162));
		persons.add(new Teacher("TREMBLAY", "Marc", Gender.HOMME, 176));
		persons.add(new Teacher("BIANKA", "Serge", Gender.OTHER, 168));

		long total = 0;
		int nbPers = 0;
		for (Person person : persons) {
			if (person.getGender() == Gender.FEMME) {
				nbPers++;
				total += person.getHeight();
			}
		}
		double result = (double) total / nbPers;
		System.out.println("Taille moyenne des femmes = " + result);
	}

	public void operationJavaStream() {
		List<Person> persons = new ArrayList<>(6);
		persons.add(new Teacher("Ali", "ALAMI", Gender.HOMME, 176));
		persons.add(new Teacher("Mohamed", "AMINE", Gender.HOMME, 190));
		persons.add(new Teacher("CONNOR", "Lara", Gender.FEMME, 172));
		persons.add(new Teacher("BERTRAND", "Virginie", Gender.FEMME, 162));
		persons.add(new Teacher("TREMBLAY", "Marc", Gender.HOMME, 176));
		persons.add(new Teacher("BIANKA", "Serge", Gender.OTHER, 168));

		double result = persons.stream().filter(p -> p.getGender() == Gender.FEMME).mapToInt(p -> p.getHeight())
				.average().getAsDouble();
		System.out.println("Taille moyenne des femmes = " + result);
	}

}
