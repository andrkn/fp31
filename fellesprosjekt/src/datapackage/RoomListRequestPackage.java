package datapackage;

public class RoomListRequestPackage implements DataPackage{

	private int capacity; 
	private int packageNumber;
	private int totalPackages;
	
	public RoomListRequestPackage(int capacity, int packageNumber, int totalPackages){
		this.capacity = capacity; 
		this.packageNumber = packageNumber;
		this.totalPackages = totalPackages;
	}
	
	public int getCapacity(){
		return capacity;
	}

	@Override
	public int getPackageNumber() {
		return packageNumber;
	}

	@Override
	public int getTotalPackages() {
		return totalPackages;
	}
	
}
