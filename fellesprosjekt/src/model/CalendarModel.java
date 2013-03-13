package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class CalendarModel implements PropertyChangeListener {
	
	ArrayList<Event> eventList;
	PropertyChangeSupport scp;
	
	public void addEvent(String name, String description) {
		
	}
	
	public void removeEvent(Event event) {
		
	}
	
	public void addEvent(Event event) {
		
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

	public ArrayList<Event> getEventList() {
		return eventList;
	}
	
	public void setEventList(ArrayList<Event> eventList) {
		this.eventList = eventList;
	}
	
	public PropertyChangeSupport getScp() {
		return scp;
	}
	
	public void setScp(PropertyChangeSupport scp) {
		this.scp = scp;
	}

	
}
