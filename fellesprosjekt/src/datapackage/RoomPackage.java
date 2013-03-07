package datapackage;

import model.Room;

public class RoomPackage implements DataPackage{
	
	private int packageNr; 
	private int totalPackages; 
	private Room room;

	public RoomPackage(int packageNr, int totalPackages, Room room) {
		this.packageNr = packageNr;
		this.totalPackages = totalPackages;
		this.room = room;
	}

	public int getPackageNr() {
		return packageNr;
	}

	public int getTotalPackages() {
		return totalPackages;
	}

	public Room getRoom() {
		return room;
	}
}
