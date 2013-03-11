package model;

import java.util.Date;

public class EventModel {
	
	private Event event; 
	private Person user;
	private boolean editable;
	
	public EventModel(Event event, Person user){
		this.event = event;
		this.user = user;
	}

	
	public String getStartTime(){
		String startTimeString = "";
		Date startTime = event.getStartTime();
		
		if (startTime == null){
			return ""; 
		}
		
		startTimeString += startTime.getHours()+":";
		startTimeString += startTime.getMinutes()+" ";
		startTimeString += startTime.getDate()+".";
		startTimeString += (startTime.getMonth()+1)+".";
		startTimeString += startTime.getYear();
		return startTimeString; 
	}
	
	public String getEndTime(){
		String endTimeString = "";
		Date endTime = event.getEndTime();

		if (endTime == null){
			return ""; 
		}
		
		endTimeString += endTime.getHours()+":";
		endTimeString += endTime.getMinutes()+" ";
		endTimeString += endTime.getDate()+".";
		endTimeString += (endTime.getMonth()+1)+".";
		endTimeString += endTime.getYear();
		return endTimeString; 
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
	
	public boolean getEditable(){
		return editable;
	}
	
	public void setEditeble(boolean editeble){
		if (this.user.equals(event.getCreatedBy())){
			this.editable = editeble;
		}
	}
}
