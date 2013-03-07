package model;

public class Room implements Comparable<Room>{
	
	private String roomNr; 
	private int capacity; 
	
	public Room(String roomNr, int capacity){
		this.roomNr = roomNr; 
		this.capacity = capacity;
	}

	public String getRoomNr() {
		return roomNr;
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public int compareTo(Room room) {
		return Integer.compare(this.capacity, room.capacity);
	}

}
