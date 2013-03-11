package gui;

import java.util.Date;

import javax.swing.JFrame;

import model.Event;
import model.EventModel;
import model.Person;

public class EventPanelTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setContentPane(new EventPanel(new EventModel(new Event(99, new Person(), new Date(2013,0,1), new Date(2013,0,2), "Name", "Decription", "Place", null, null, null), new Person())));
		frame.setSize(500,350); 
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
		
		Date date = new Date(92,9,25); 
		System.out.println(date);
		
	}

}
