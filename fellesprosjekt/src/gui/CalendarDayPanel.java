package gui;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import com.sun.org.apache.xalan.internal.xsltc.dom.AbsoluteIterator;

import model.Event;
import model.EventModel;
import model.Person;

public class CalendarDayPanel extends JPanel{
	
	
	
	public CalendarDayPanel(ArrayList<Event> events, int width, int height){
		
		
		this.setLayout(new GridBagLayout());
		this.setLayout(null);
		
		for (Event event : events){
			JPanel eventPanel = new EventPreview(new EventModel(event, new Person()));
//			eventPanel.setAlignmentY((height/24)*event.getStartTime().getHours());
			this.add(eventPanel);
			eventPanel.setBounds(2, (height/24)*event.getStartTime().getHours(), width-5,70);
//			eventPanel.setLocation(100, 100);
//			eventPanel.setSize(70, 70);
//			
//			eventPanel.setVisible(true);
		}
//		JLabel l = new JLabel("Halla");
//		this.add(l);
//		l.setBounds(0, 0, width, 30);
//		l.setLocation(50, 60); 
//		l.setSize(230, 40);
//		this.setSize(1000, 1000);
//		this.setBackground(Color.GREEN);
//		System.out.println(this.getComponentCount());
//		this.setVisible(true);
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		this.validate(); 
		this.repaint();
	}
	
	public void update(){
		
	}

}
