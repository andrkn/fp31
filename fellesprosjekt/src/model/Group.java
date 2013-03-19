package model;

import java.util.ArrayList;

public class Group implements HaveCalendar {
	
	private int groupId;
	private String name;
	private ArrayList<Person> members;

	public void setGroupId(int groupId){
		this.groupId = groupId;
	}
	
	public int getGroupId(){
		return groupId;
	}
	
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

	@Override
	public int compareTo(HaveCalendar other) {
		try {
			return this.getName().compareTo(other.getName());
		} catch (NullPointerException e) {
		}
		return 0;
	}

}
