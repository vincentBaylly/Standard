package org.initial.collection;

import java.util.LinkedList;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MyListe
{
	
	private LinkedList liste;

	public void setMember(String s)
	{
		liste.add(s);
	}
	public int getMember(int i)
	{
		return (int)liste.get(i);
	}
}

/**
 * 
 * Utilisation
 * Family<String> family = new Family<String>();
 * family.setMember("essai");
 * family.setMember(210);          //seconde erreur
 * 
 */
class Family < MyClass >
{
	private LinkedList < MyClass > list;

	public void setMember(MyClass m)
	{
		list.add(m);
	}

	public MyClass getMember(int i)
	{
		return list.get(i);
	}

	/*
	 * public Integer getInt(int i) //première erreur { return liste.get(i); }
	 */
}
