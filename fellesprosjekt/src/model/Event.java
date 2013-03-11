package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import model.HaveCalendar;
import model.Person;
import model.Room;

public class Event {
	
	private String name, description, place;
	private Person createdBy;
	private int eventId;
	private Room room;
	private Date startTime, endTime;
	private Boolean isActive;
	private ArrayList<HaveCalendar> attenders;
	private HashMap<Person, Integer> alarms;
	
	public Event(int eventId, Person createdBy, Date startTime, Date endTime, String name, 
	String description, String place, String invitedPersons, String invitedGroups, String roomNr){
		this.createdBy = createdBy;
		this.startTime = startTime;
		this.endTime = endTime;
		this.name = name;
		this.description = description;
		this.place = place;

	}
	
	public void setCreatedBy(Person createdBy){
		this.createdBy = createdBy;
	}
	public Person getCreatedBy(){
		return createdBy;
	}
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date time) {
		this.startTime = time;
	}
	public Date getEndTime(){
		return endTime;
	}
	public void setEndTime(Date time){
		this.endTime = time;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public void setAttenders(ArrayList<HaveCalendar> attenders){
		this.attenders = attenders;
	}
	
	public ArrayList<HaveCalendar> getAttenders(){
		return attenders;
	}
	
	public void addAttender(HaveCalendar haveCalendar){
		if (attenders == null){
			attenders = new ArrayList<HaveCalendar>();
		}
		attenders.add(haveCalendar); 
	}
	
	public void removeAttender(HaveCalendar haveCalendar){
		attenders.remove(haveCalendar); 
	}
	
	public int getNumberOfAttenders(){
		return attenders.size();
	}

	public void setAlarms(Person person, int eventId) {
		alarms.put(person, eventId);
	}

	public HashMap<Person, Integer> getAlarms() {
		return alarms;
	}

	

	
}
