package org.beans;

public class Room {
	private int id;
	private String code;
	private String label;
 
	private static int comp;
 
	public Room(String code, String label) {
		this.id = ++comp;
		this.code = code;
		this.label = label;
	}
 
	public Room(int id, String code, String label) {
		this.id = id;
		this.code = code;
		this.label = label;
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getCode() {
		return code;
	}
 
	public void setCode(String code) {
		this.code = code;
	}
 
	public String getLabel() {
		return label;
	}
 
	public void setLabel(String label) {
		this.label = label;
	}
 
	public String toString() {
		return this.code + " " + this.label;
	}
 
}
