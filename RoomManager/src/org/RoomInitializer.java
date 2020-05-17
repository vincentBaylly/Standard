package org;

import java.util.Scanner;

import org.beans.Room;
import org.service.RoomService;
 
public class RoomInitializer {
 
	public static void main(String[] args) {
		RoomService roomService = new RoomService();
 
		roomService.create(new Room("A", "Salle 1"));
		roomService.create(new Room("B", "Salle 2"));
		roomService.create(new Room("C", "Salle 3"));
		roomService.create(new Room("D", "Salle 4"));
 
		System.out.println("La liste des salles :");
		for (Room s : roomService.findAll())
			System.out.println("\t" + s);
 
		System.out.println("Supprimer la salle avec id = 1");
		roomService.delete(roomService.findById(1));
 
		System.out.println("Modifier la salle avec id = 2");
		Room room = roomService.findById(2);
 
		System.out.println("\tSalle à modifier : " + room);
 
		Scanner scanner = new Scanner(System.in);
		System.out.println("Donner le nouveau code :");
		room.setCode(scanner.nextLine());
		System.out.println("Donner le nouveau libelle :");
		room.setLabel(scanner.nextLine());
		roomService.update(room);
 
		System.out.println("La liste des salles après les mises à jour :");
		for (Room s : roomService.findAll())
			System.out.println("\t" + s);
		
		scanner.close();
 
	}
 
}
