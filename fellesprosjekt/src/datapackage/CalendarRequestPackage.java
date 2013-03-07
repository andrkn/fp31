package datapackage;

import model.HaveCalendar;

public class CalendarRequestPackage implements DataPackage{
	
	private HaveCalendar hc;
	
	public CalendarRequestPackage(HaveCalendar hc){
		this.hc = hc; 
	}
	public HaveCalendar getHaveCalendar(){
		return hc;
	}

}
