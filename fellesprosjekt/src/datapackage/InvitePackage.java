package datapackage;

import java.util.ArrayList;

import model.HaveCalendar;

public class InvitePackage implements DataPackage{

	private int packageNumber; 
	private int totalPackages; 
	private int eventID; 
	private ArrayList<HaveCalendar> hcList; 
	
	
	public InvitePackage(int eventID, ArrayList<HaveCalendar> hcList, int packageNumber, int totalPackages){
		this.eventID = eventID; 
		this.hcList = hcList; 
		this.packageNumber = packageNumber; 
		this.totalPackages = totalPackages;
	}
	
	public int getPackageNumber() {
		return packageNumber;
	}

	public int getTotalPackages() {
		return totalPackages;
	}

	public int getEventID() {
		return eventID;
	}

	public ArrayList<HaveCalendar> getHaveCalendar() {
		return hcList;
	}
	
	

}
