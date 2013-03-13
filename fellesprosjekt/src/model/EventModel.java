package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class EventModel {
	
	private Event event; 
	private Person user;
	private boolean editable;
	private PropertyChangeSupport pcs; 
	
	public EventModel(Event event, Person user){
		this.event = event;
		this.user = user;
		editable = false;
		pcs = new PropertyChangeSupport(this); 
	}

	
	public String getStartTime(){
		return getTimeString(event.getStartTime()); 
	}
	public void setStartTime(String startTimeString){
		event.setStartTime(getTimestamp(startTimeString));
	}
	
	public String getEndTime(){
		return getTimeString(event.getEndTime()); 
	}
	public void setEndTime(String endTimeString){
		event.setEndTime(getTimestamp(endTimeString));
	}
	
	private Timestamp getTimestamp(String timeString) {
		
		String[] time_date = timeString.split(" ");
		String[] time = time_date[0].split(":");
		String[] date = time_date[1].split("\\.");

		
		int year = Integer.parseInt(date[2])-1900;
		int month = Integer.parseInt(date[1])-1;
		int day = Integer.parseInt(date[0]);
		
		int hour = Integer.parseInt(time[0]); 
		int minute = Integer.parseInt(time[1]);
		
		Timestamp timestamp = new Timestamp(year, month, day, hour, minute, 0, 0); 
		return timestamp;
	}
	
	public String getPlace(){
		if (event.getRoom() != null){
			return event.getRoom().getRoomNr();
		}else{
			return event.getPlace(); 
		}
	}
	
	public String getName(){
		return event.getName();
	}
	public void setName(String name){
		event.setName(name); 
	}
	
	public String getDescription() {
		return event.getDescription();
	}
	public void setDescription(String description){
		event.setDescription(description); 
	}
	
	public String getAlarm(){
		int alarm = event.getAlarms().get(user);
		return Integer.toString(alarm);
	}
	public void setAlarm(int alarm){
		event.setAlarm(user, alarm);
	}


	public ArrayList<Person> getInviteList(){
		ArrayList<Person> test = new ArrayList<Person>();
		Person p1 = new Person(); 
		p1.setName("Torstein"); 
		
		Person p2 = new Person(); 
		p2.setName("Adam");
		
		test.add(p1);
		test.add(p2);
		return test;
	}


	public ArrayList<Person> getAttenders(){
		ArrayList<Person> test = new ArrayList<Person>();
		Person p1 = new Person(); 
		p1.setName("Per"); 
		
		Person p2 = new Person(); 
		p2.setName("Simon");
		
		Person p3 = new Person(); 
		p3.setName("Kristoffer");
		
		test.add(p1);
		test.add(p2);
		test.add(p3);
		return test;
	}

	public boolean getEditable(){
		return editable;
	}
	
	public void setEditeble(boolean editeble){
		if (this.editable == editeble){
			return;
		}
		this.editable = editeble;
		pcs.firePropertyChange("editeble", !editeble, editeble);
	}


	private String getTimeString(Timestamp date){
		if (date == null){
			return ""; 
		}

		String dateString = "";
		
		dateString += date.getHours()+":";
		dateString += date.getMinutes()+" ";
		dateString += date.getDate()+".";
		dateString += (date.getMonth()+1)+".";
		dateString += (date.getYear()+1900);
		return dateString;
	}
	
	public void addAttender(Person person){
		
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener){
		pcs.addPropertyChangeListener(listener); 
	}
	public void removePropertyChangeListener(PropertyChangeListener listener){
		pcs.removePropertyChangeListener(listener); 
	}
}
