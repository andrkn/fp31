package datapackage;

import model.HaveCalendar;

public class HaveCalendarPackage implements DataPackage{
	
	private int packageNumber; 
	private int totalPackages; 
	private HaveCalendar hc;
	
	public HaveCalendarPackage(int packageNumber, int totalPackages, HaveCalendar hc) {
		this.packageNumber = packageNumber;
		this.totalPackages = totalPackages;
		this.hc = hc;
	}

	public int getPackageNr() {
		return packageNumber;
	}

	public int getTotalPackages() {
		return totalPackages;
	}

	public HaveCalendar getHc() {
		return hc;
	}

	@Override
	public int getPackageNumber() {
		// TODO Auto-generated method stub
		return packageNumber;
	} 
}
