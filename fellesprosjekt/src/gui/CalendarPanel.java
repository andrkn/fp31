package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.CalendarModel;
import model.Event;

public class CalendarPanel extends JPanel{

	CalendarModel model; 
	GridBagConstraints grid; 
	
	public CalendarPanel(CalendarModel model){
		this.model = model; 
		this.setLayout(new GridBagLayout()); 
		
		
		
	}
	
	public void update(){
		ArrayList<Event> events = model.getEventList();
		
		JPanel dayPanel = new CalendarDayPanel(events);
		this.add(dayPanel);
		
	}
	
}
