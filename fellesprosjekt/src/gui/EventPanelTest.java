package gui;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;

import model.Event;
import model.EventModel;
import model.Person;

public class EventPanelTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		JFrame frame = new JFrame();
		
		EventModel model = new EventModel(
				new Event(99, new Person(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 
						"Name", "Decription", "Place", null, null,null), new Person());
		EventPanel panel = new EventPanel(model);
		frame.setContentPane(panel);
		frame.setSize(500,350); 
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
		
		
//		model.setEditeble(true); 
//		panel.setEditeble();
		
		
		
		
		while (true){
			
			model.setEditeble(!model.getEditable());
			panel.setEditeble(); 
			
			Thread.sleep(5000); 
			
		}
	}
}