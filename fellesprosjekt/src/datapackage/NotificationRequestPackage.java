package datapackage;

public class NotificationRequestPackage implements DataPackage{

	private int packageNumber, totalPackages;
	
	public NotificationRequestPackage(int packageNumber, int totalPackages) {
		this.packageNumber = packageNumber;
		this.totalPackages = totalPackages;
	}

	public int getPackageNumber() {
		return packageNumber;
	}

	public void setPackageNumber(int packageNumber) {
		this.packageNumber = packageNumber;
	}

	public int getTotalPackages() {
		return totalPackages;
	}

	public void setTotalPackages(int totalPackages) {
		this.totalPackages = totalPackages;
	}

	
}
