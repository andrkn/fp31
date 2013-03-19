package datapackage;


public class NotificationRequestPackage implements DataPackage{

	private int packageNumber, totalPackages;
	private String username;
	
	public NotificationRequestPackage(int packageNumber, int totalPackages, String username) {
		this.packageNumber = packageNumber;
		this.totalPackages = totalPackages;
		this.username = username;
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

	public String getUsername() {
		return username;
	}

	

	
}
