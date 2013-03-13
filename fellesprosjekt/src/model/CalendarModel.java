package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Timestamp;
import java.util.ArrayList;

public class CalendarModel implements PropertyChangeListener {
	
	ArrayList<Event> eventList;
	PropertyChangeSupport scp;
	
	public CalendarModel() {
		eventList = new ArrayList<Event>();
	}
	
	public void addEvent(int eventId, Person createdBy, Timestamp startTime, Timestamp endTime, String name, String description, String place, Room room, ArrayList<HaveCalendar> attenders) {
		Event newEvent = new Event(eventId, createdBy, startTime, endTime, name, description, place, room, attenders);
		eventList.add(newEvent);
	}
	
	public void removeEvent(Event event) {
		eventList.remove(event);
	}
	
	public void changeEvent(Event event, Timestamp startTime, Timestamp endTime, String name, String description, String place, Room room, ArrayList<HaveCalendar> attenders) {
		event.setStartTime(startTime);
		event.setEndTime(endTime);
		event.setName(name);
		event.setDescription(description);
		event.setPlace(place);
		event.setAttenders(attenders);
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
