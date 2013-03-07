package model;

import java.util.ArrayList;

public class Group implements HaveCalendar {
	
	String name;
	ArrayList<Person> members;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Person> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Person> members) {
		this.members = members;
	}

	@Override
	public CalendarModel getCalendar() {
		// TODO Auto-generated method stub
		return null;
	}

}
