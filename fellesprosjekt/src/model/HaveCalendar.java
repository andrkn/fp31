package model;

import java.io.Serializable;

public interface HaveCalendar extends Comparable<HaveCalendar>, Serializable{

	CalendarModel getCalendar();
	String getName();
	
}
