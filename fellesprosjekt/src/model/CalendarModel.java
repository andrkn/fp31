package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class CalendarModel implements PropertyChangeListener {
	
	ArrayList<Person> eventList;
	PropertyChangeSupport scp;
	
	public void addEvent(String name, String description) {
		
	}
	
	public void removeEvent(Event event) {
		
	}
	
	public void changeEvent(Event event, String name, String description) {
		
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		
	}
	
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Person> getEventList() {
		return eventList;
	}
	public void setEventList(ArrayList<Person> eventList) {
		this.eventList = eventList;
	}
	public PropertyChangeSupport getScp() {
		return scp;
	}
	public void setScp(PropertyChangeSupport scp) {
		this.scp = scp;
	}

	
}
