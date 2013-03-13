<<<<<<< HEAD
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
=======
package datapackage;

import model.HaveCalendar;

public class CalendarRequestPackage implements DataPackage{
	
	private String name;
	private Integer group;
	
	public CalendarRequestPackage(String name, Integer group){
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
>>>>>>> Upgrading to support CalReqPacks
