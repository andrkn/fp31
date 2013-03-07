package datapackage;

import model.HaveCalendar;

public class HaveCalendarPackage implements DataPackage{
	
	private int packageNr; 
	private int totalPackages; 
	private HaveCalendar hc;
	
	public HaveCalendarPackage(int packageNr, int totalPackages, HaveCalendar hc) {
		this.packageNr = packageNr;
		this.totalPackages = totalPackages;
		this.hc = hc;
	}

	public int getPackageNr() {
		return packageNr;
	}

	public int getTotalPackages() {
		return totalPackages;
	}

	public HaveCalendar getHc() {
		return hc;
	} 
}
