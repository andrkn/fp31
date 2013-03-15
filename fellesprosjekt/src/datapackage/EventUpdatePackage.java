package datapackage;

public class EventUpdatePackage implements DataPackage {
	
	private int eventID; 
	private String property; 
	private Object newValue;
	private int packageNumber;
	private int totalPackages;
	
	public EventUpdatePackage(int eventID, String property, Object newValue, int packageNumber, int totalPackages) {
		this.eventID = eventID;
		this.property = property;
		this.newValue = newValue;
		this.packageNumber = packageNumber;
		this.totalPackages = totalPackages;
	}
	public int getEventID() {
		return eventID;
	}
	public String getProperty() {
		return property;
	}
	public Object getNewValue() {
		return newValue;
	}
	@Override
	public int getPackageNumber() {
		return packageNumber;
	}
	@Override
	public int getTotalPackages() {
		return totalPackages;
	} 
	
	

}
