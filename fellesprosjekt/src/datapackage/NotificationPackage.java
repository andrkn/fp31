package datapackage;

public class NotificationPackage implements DataPackage {

	private int packageNumber, totalPackages;

	public NotificationPackage(int packageNumber, int totalPackages) {
		this.packageNumber = packageNumber;
		this.totalPackages = totalPackages;
	}
	
	
	@Override
	public int getPackageNumber() {
		// TODO Auto-generated method stub
		return packageNumber;
	}

	@Override
	public int getTotalPackages() {
		// TODO Auto-generated method stub
		return totalPackages;
	}

}
