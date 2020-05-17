package org.initial.exercices;

import java.util.Scanner;

public class Exercice4 {

	public static void main(String[] args) {
		Exercice4.arraySearch();
	}

	public static void arraySearch() {
		char charArray[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
		int i = 0;
		char reponse = ' ', myChar = ' ';
		Scanner sc = new Scanner(System.in);

		do {// Boucle principale
			do {// On répète cette boucle tant que l'utilisateur n'a pas rentré une lettre
				// figurant dans le tableau
				i = 0;
				System.out.println("Rentrez une lettre en minuscule, SVP ");

				myChar = sc.nextLine().charAt(0);
				// Boucle de recherche dans le tableau
				while (i < charArray.length && myChar != charArray[i])
					i++;

				// Si i < 7 c'est que la boucle n'a pas dépassé le nombre de cases du tableau
				if (i < charArray.length)
					System.out.println(" La lettre " + myChar + " se trouve bien dans le tableau !");
				else // Sinon
					System.out.println(" La lettre " + myChar + " ne se trouve pas dans le tableau !");

			} while (i >= charArray.length);

			// Tant que la lettre de l'utilisateur ne correspond pas à une lettre du tableau
			do {
				System.out.println("Voulez-vous essayer à nouveau ? (O/N)");
				reponse = sc.nextLine().charAt(0);
			} while (reponse != 'N' && reponse != 'O');
		} while (reponse == 'O');

		System.out.println("Au revoir !");

		sc.close();
	}

	public static void arraySearch(char searchElement) {
		char charArray[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
		int i = 0;


		do {// On répète cette boucle tant que l'utilisateur n'a pas rentré une lettre
			// figurant dans le tableau
			i = 0;
			System.out.println("Rentrez une lettre en minuscule, SVP ");

			// Boucle de recherche dans le tableau
			while (i < charArray.length && searchElement != charArray[i])
				i++;

			// Si i < 7 c'est que la boucle n'a pas dépassé le nombre de cases du tableau
			if (i < charArray.length)
				System.out.println(" La lettre " + searchElement + " se trouve bien dans le tableau !");
			else // Sinon
				System.out.println(" La lettre " + searchElement + " ne se trouve pas dans le tableau !");

		} while (i >= charArray.length);

	}

}
