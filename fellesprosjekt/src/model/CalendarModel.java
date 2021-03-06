package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class CalendarModel implements PropertyChangeListener {
	
	private ArrayList<Event> eventList;
	private PropertyChangeSupport pcs;
	private int weekNr; 
	private int year;
	
	public int getWeekNr() {
		return weekNr;
	}

	public void setWeekNr(int weekNr) {
		int oldWeekNr = this.weekNr;
		this.weekNr = weekNr;
		pcs.firePropertyChange("setWeekNr", oldWeekNr, weekNr);
	}
	
	public void incrementWeek(){
		int oldWeekNr = this.weekNr;
		this.weekNr = weekNr + 1;
		if (this.weekNr > 52){
			this.weekNr = 1;
			int oldyear = getYear();
			int newyear = oldyear + 1;
			setYear(newyear);
		}
		System.out.println(weekNr);
		pcs.firePropertyChange("setWeekNr", oldWeekNr, weekNr);
	}
	
	public void decrementWeek(){
		int oldWeekNr = this.weekNr;
		this.weekNr = weekNr - 1;
		if (this.weekNr < 1){
			this.weekNr = 52;
			int oldyear = getYear();
			int newyear = oldyear - 1;
			setYear(newyear);
		}
		System.out.println(weekNr);
		pcs.firePropertyChange("setWeekNr", oldWeekNr, weekNr);
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		int oldYear = this.year;
		this.year = year;
		pcs.firePropertyChange("setYear", oldYear, year);
	}

	public CalendarModel() {
		eventList = new ArrayList<Event>();
		pcs = new PropertyChangeSupport(this);
		Calendar cal = Calendar.getInstance();
		this.year = 1900 + cal.getTime().getYear();
		this.weekNr = cal.WEEK_OF_YEAR + 9;
	}
	
	public void addEvent(int eventId, Person createdBy, Timestamp startTime, Timestamp endTime, String name, String description, String place, Room room, ArrayList<HaveCalendar> attenders) {
		Event newEvent = new Event(eventId, createdBy, startTime, endTime, name, description, place, room, attenders);
		eventList.add(newEvent);
		pcs.firePropertyChange("addEvent", null, newEvent);
	}
	public void addEvent(Event event){
		eventList.add(event);
		pcs.firePropertyChange("addEvent", null, event); 
	}
	
	public void addEvents(ArrayList<Event> events) {
		pcs.firePropertyChange("UPDATING_EVENTS", this.eventList, events);
		this.eventList = events;
	}
	
	public void removeEvent(Event event) {
		eventList.remove(event);
		pcs.firePropertyChange("removeEvent", null, event);
	}
	
	public void changeEvent(Event event, Timestamp startTime, Timestamp endTime, String name, String description, String place, Room room, ArrayList<HaveCalendar> attenders) {
		event.setStartTime(startTime);
		event.setEndTime(endTime);
		event.setName(name);
		event.setDescription(description);
		event.setPlace(place);
		event.setRoom(room);
		event.setAttenders(attenders);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Event> getEventList() {
		return eventList;
	}
	
	public void setEventList(ArrayList<Event> eventList) {
		ArrayList<Event> oldEventList = this.eventList;
		this.eventList = eventList;
		pcs.firePropertyChange("setEventList", oldEventList, eventList);
	}
	
	public Timestamp getWeekStart(){
		int week = this.weekNr; 
		int year = this.year;
		// Get calendar, clear it and set week number and year.
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.WEEK_OF_YEAR, week);
		calendar.set(Calendar.YEAR, year);
		
		return new Timestamp(calendar.getTimeInMillis());
	}
	
}
