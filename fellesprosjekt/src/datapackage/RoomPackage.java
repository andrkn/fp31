package datapackage;

import model.Room;

public class RoomPackage implements DataPackage{
	

	private int totalPackages; 
	private int packageNumber;
	private Room room;

	public RoomPackage(int packageNumber, int totalPackages, Room room) {
		this.packageNumber = packageNumber;
		this.totalPackages = totalPackages;
		this.room = room;
	}

	public int getPackageNumber() {
		return packageNumber;
	}

	public int getTotalPackages() {
		return totalPackages;
	}

	public Room getRoom() {
		return room;
	}
}
