package gui;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


import model.CalendarModel;
import model.Event;
import model.HaveCalendar;
import model.Person;

public class CalendarPanelTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame(); 
		

		CalendarModel model = new CalendarModel();
		ArrayList<HaveCalendar> test = new ArrayList<HaveCalendar>();
		
		Event e1 = new Event(99, new Person(), new Timestamp(System.currentTimeMillis()), 
				new Timestamp(System.currentTimeMillis()), 
				"Name", "Decription", "Place", null, test);
		
		Event e2 = new Event(99, new Person(), new Timestamp(System.currentTimeMillis()), 
				new Timestamp(System.currentTimeMillis()), 
				"Name", "Decription", "Place", null, test); 
		
		
		
		
		model.addEvent(e1); 
		model.addEvent(e2);
		
		JPanel calendarPanel = new CalendarPanel(model); 
		
		frame.setContentPane(calendarPanel); 
		frame.setSize(800, 600); 
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
		
	}
	
}
