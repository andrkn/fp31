package gui;

import java.util.ArrayList;

import javax.swing.JPanel;

import com.sun.org.apache.xalan.internal.xsltc.dom.AbsoluteIterator;

import model.Event;
import model.EventModel;
import model.Person;

public class CalendarDayPanel extends JPanel{
	
	
	
	public CalendarDayPanel(ArrayList<Event> events){
		
		
		this.setLayout(null);
		
		
		int height = this.getHeight();
		
		for (Event event : events){
			JPanel eventPanel = new EventPreview(new EventModel(event, new Person()));
			eventPanel.setAlignmentY((height/24)*event.getStartTime().getHours());
			this.add(eventPanel);
		}
		
	}
	
	public void update(){
		
	}

}
