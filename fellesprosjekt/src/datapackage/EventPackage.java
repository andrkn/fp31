package datapackage;

import model.Event;

public class EventPackage implements DataPackage {

	private int packageNr; 
	private int totalPackages; 
	private Event event;

	public EventPackage(int packageNr, int totalPackages,
			Event event) {
		this.packageNr = packageNr;
		this.totalPackages = totalPackages;
		this.event = event;
	}
	public int getPackageNr() {
		return packageNr;
	}
	public int getTotalPackages() {
		return totalPackages;
	}
	public Event getEvent() {
		return event;
	} 
	
	
}
