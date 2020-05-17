package org.initial.poo;

public class TestEnum {

	public enum Day {
		LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI, DIMANCHE
	}

	Day day;

	public TestEnum(Day day) {
		this.day = day;
	}

	public void showDays() {
		switch (day) {
		case LUNDI:
			System.out.println("Lundi");
			break;
		case MARDI:
			System.out.println("Mardi");
			break;
		case MERCREDI:
			System.out.println("Mercredi");
			break;
		case JEUDI:
			System.out.println("Jeudi");
			break;
		case VENDREDI:
			System.out.println("Vendredi");
			break;
		case SAMEDI:
			System.out.println("Samedi");
			break;
		case DIMANCHE:
			System.out.println("Dimanche");
			break;
		}
	}

	public static void main(String[] args) {
		TestEnum testEnum = new TestEnum(Day.SAMEDI);
		testEnum.showDays();
	}
}