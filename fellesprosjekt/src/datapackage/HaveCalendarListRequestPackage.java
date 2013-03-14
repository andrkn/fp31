package datapackage;

public class HaveCalendarListRequestPackage implements DataPackage {
	
	private int packageNumber, totalPackages;

	public HaveCalendarListRequestPackage(int packageNumber, int totalPackages) {
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
