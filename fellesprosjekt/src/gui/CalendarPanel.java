package gui;

import java.awt.Color;
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
		this.setBounds(10, 10, 50,20);
		
		update();
		System.out.println(this.getComponentCount());
		
		this.setVisible(true);
		this.setBackground(Color.BLUE); 
		this.validate(); 
		this.repaint();
	}
	
	public void update(){
		ArrayList<Event> events = model.getEventList();
		
		JPanel dayPanel = new CalendarDayPanel(events);
		this.add(dayPanel);
		
	}
	
}
