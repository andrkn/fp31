package gui;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Event;
import model.EventModel;
import model.HaveCalendar;
import model.Person;

public class EventPanelTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		JFrame frame = new JFrame();
		
		Person p = new Person();
		p.setName("Torstein");
		
		ArrayList<HaveCalendar> test = new ArrayList<HaveCalendar>();
//		Person p1 = new Person(); 
//		p1.setName("Per"); 
//		
//		Person p2 = new Person(); 
//		p2.setName("Simon");
//		
//		Person p3 = new Person(); 
//		p3.setName("Kristoffer");
//		
//		test.add(p1);
//		test.add(p2);
//		test.add(p3);
		
		JPanel mainPanel = new JPanel();
		
		
		EventModel model = new EventModel(
				new Event(99, new Person(), new Timestamp(System.currentTimeMillis()), 
						new Timestamp(System.currentTimeMillis()), 
						"Name", "Decription", "Place", null, test), p);
		model.setMapAlarm(p, model.getTimestamp(model.getStartTime() + 10000));
		EventPanel panel = new EventPanel(model);
		
		mainPanel.add(panel);
		mainPanel.add(new EventPreview(model));
		
		frame.setContentPane(mainPanel);
		frame.setSize(500,600); 
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
		
		
		
		
		
		
//		while (true){
//			
//			model.setEditeble(!model.getEditable());
//			panel.setEditeble(); 
//			
//			Thread.sleep(3000); 
//			
//		}
	}
}
