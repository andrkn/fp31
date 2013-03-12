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
	
	public String getEndTime(){
		return getTimeString(event.getEndTime()); 
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
	
	public String getDescription() {
		return event.getDescription();
	}
	
	public String getAlarm(){
		int alarm = event.getAlarms().get(user);
		return Integer.toString(alarm);
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
		p1.setName("Torstein"); 
		
		Person p2 = new Person(); 
		p2.setName("Adam");
		
		test.add(p1);
		test.add(p2);
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
