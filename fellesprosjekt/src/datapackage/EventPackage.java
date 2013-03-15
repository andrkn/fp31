package datapackage;

import model.Event;

public class EventPackage implements DataPackage {

	private int packageNumber; 
	private int totalPackages; 
	private Event event;

	public EventPackage(int packageNumberr, int totalPackages, Event event) {
		this.packageNumber = packageNumber;
		this.totalPackages = totalPackages;
		this.event = event;
	}
	public int getPackageNr() {
		return packageNumber;
	}
	public int getTotalPackages() {
		return totalPackages;
	}
	public Event getEvent() {
		return event;
	}
	@Override
	public int getPackageNumber() {
		// TODO Auto-generated method stub
		return packageNumber;
	} 
	
	
}
