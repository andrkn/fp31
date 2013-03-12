package model;

import java.util.concurrent.Callable;


public class Person implements HaveCalendar, Comparable<Person>{
	
	String name, email;
	CalendarModel model;
	
	@Override
	public CalendarModel getCalendar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCalendarModel(CalendarModel model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString(){
		return name;
	}

	@Override
	public int compareTo(Person other) {
		return this.getName().compareTo(other.getName());
	}

}
