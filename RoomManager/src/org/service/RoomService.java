package org.service;

import java.util.ArrayList;
import java.util.List;

import org.beans.Room;
import org.dao.IDao;
 
public class RoomService implements IDao<Room> {
 
	private List<Room> rooms;
 
	public RoomService() {
		rooms = new ArrayList<Room>();
	}
 
	@Override
	public boolean create(Room o) {
		return rooms.add(o);
	}
 
	@Override
	public boolean update(Room o) {
		for(Room s : rooms){
			if(s.getId() == o.getId()){
				s.setCode(o.getCode());
				s.setLabel(o.getLabel());
				return true;
			}
		}
		return false;
	}
 
	@Override
	public boolean delete(Room o) {
		return rooms.remove(o);
	}
 
	@Override
	public List<Room> findAll() {
		return rooms;
	}
 
	@Override
	public Room findById(int id) {
		for (Room s : rooms) {
			if (s.getId() == id)
				return s;
		}
		return null;
	}
 
}
