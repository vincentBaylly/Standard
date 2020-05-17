package org.initial.heritage;

interface Dog {

	void toGetOld();

	void bark();
}

public abstract class AbstractDog implements Dog {
	// Champs
	// On met les champs en protected pour que les classes filles
	// puissent les manipuler directement
	protected int age;
	protected String color;
	
	public AbstractDog() {
		
	}
	
	// Constructeur
	// Pourra être utilisé par les classes filles pour initialiser les champs.
	public AbstractDog(int age, String color) {
		this.age = age;
		this.color = color;
	}

	// Méthode

	// On donne l'implémentation qui est commune à tous les chiens
	public void toGetOld() {
		age++;
	}

	// Cette méthode n'est définie que par les classes filles
	// Elle est donc laissée abstract.
	public abstract void bark();

}

//public class BullDog implements Dog{
//
//protected int age;
//
//public void toGetOld() {
//	age++;
//}
//}
