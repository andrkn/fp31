package datapackage;

import model.HaveCalendar;

public class CalendarRequestPackage implements DataPackage{
	
	private String name;
	private int group;
	
	public CalendarRequestPackage(String name, int group){
		this.name = name;
		this.group = group;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getGroup(){
		return this.group;
	}

}
