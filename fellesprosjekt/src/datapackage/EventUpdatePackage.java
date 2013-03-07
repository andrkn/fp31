package datapackage;

public class EventUpdatePackage implements DataPackage {
	
	private int eventID; 
	private String property; 
	private Object newValue;
	
	public EventUpdatePackage(int eventID, String property, Object newValue) {
		this.eventID = eventID;
		this.property = property;
		this.newValue = newValue;
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
	
	

}
