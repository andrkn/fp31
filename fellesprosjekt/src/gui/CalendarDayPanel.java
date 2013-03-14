package gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.org.apache.xalan.internal.xsltc.dom.AbsoluteIterator;

import model.Event;
import model.EventModel;
import model.Person;

public class CalendarDayPanel extends JPanel{
	
	
	
	public CalendarDayPanel(ArrayList<Event> events){
		
		
		this.setLayout(null);
		this.setBounds(10, 10, 50,20);
		
		
		int height = this.getHeight();
		
		for (Event event : events){
			JPanel eventPanel = new EventPreview(new EventModel(event, new Person()));
			eventPanel.setAlignmentY((height/24)*event.getStartTime().getHours());
			eventPanel.setSize(70, 70);
			eventPanel.setBounds(10, 10, 50,20);
			this.add(eventPanel);
			eventPanel.setVisible(true);
		}
		this.add(new JLabel("Halla"));
		this.setSize(1000, 1000);
		this.setBackground(Color.GREEN);
		System.out.println(this.getComponentCount());
		this.setVisible(true);
		this.validate(); 
		this.repaint();
	}
	
	public void update(){
		
	}

}
