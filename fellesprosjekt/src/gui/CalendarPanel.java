package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.geom.Line2D;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

import model.CalendarModel;
import model.Event;
import model.EventModel;
import model.Person;

public class CalendarPanel extends JPanel{

	CalendarModel model; 
	GridBagConstraints grid; 
	public static final long MILLISECOND_IN_DAY = 24*60*60*1000;
	
	public CalendarPanel(CalendarModel model){
		this.model = model; 
		this.setLayout(null);
		
		update();
		this.validate(); 
		this.repaint();
	}
	
	public void update(){
		
		ArrayList<Event> events = model.getEventList();
		
		Timestamp dayStart = model.getWeekStart();
		Timestamp dayEnd = new Timestamp(dayStart.getTime() + MILLISECOND_IN_DAY);
		
		int height = this.getHeight();
		int width = this.getWidth()/7;
		
		for (int i = 0; i < 7; i++){
			
			ArrayList<Event> eventsForDay = new ArrayList<Event>();
			
			for (Event event : events){
				if (event.getStartTime().after(dayStart) && event.getEndTime().before(dayEnd)){
					eventsForDay.add(event);
				}
			}
			
			JPanel dayPanel = new CalendarDayPanel(eventsForDay,width,height);
			this.add(dayPanel);
			dayPanel.setBounds((int)width*i, 0, (int)width, (int)height);
			
			dayStart = dayEnd; 
			dayEnd = new Timestamp(dayStart.getTime() + MILLISECOND_IN_DAY);
			
		}
	}
}
