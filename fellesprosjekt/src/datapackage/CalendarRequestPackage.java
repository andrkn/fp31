
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
	
	public Integer getGroup(){
		return this.group;
	}

}

