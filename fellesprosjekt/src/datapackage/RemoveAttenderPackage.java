package datapackage;

import java.util.ArrayList;

import model.Event;
import model.HaveCalendar;

public class RemoveAttenderPackage implements DataPackage{
	
	private int packageNumber;
	private int totalPackages;
	private ArrayList<HaveCalendar> hc;
	private Event event;
	
	public RemoveAttenderPackage(int packageNumber, int totalPackages, ArrayList<HaveCalendar> removeHC, Event event) {
		super();
		this.packageNumber = packageNumber;
		this.totalPackages = totalPackages;
		this.event = event;
		this.hc = removeHC;
	}

	public int getPackageNumber() {
		return packageNumber;
	}

	public int getTotalPackages() {
		return totalPackages;
	}

	public ArrayList<HaveCalendar> getHc() {
		return hc;
	}

	public Event getEvent() {
		return event;
	} 
	
}
