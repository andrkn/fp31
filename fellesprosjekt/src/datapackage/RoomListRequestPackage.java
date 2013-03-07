package datapackage;

public class RoomListRequestPackage implements DataPackage{

	private int capacity; 
	
	public RoomListRequestPackage(int capacity){
		this.capacity = capacity; 
	}
	
	public int getCapacity(){
		return capacity;
	}
	
}
