package gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import model.Event;


public class UpdateSwingWorker extends SwingWorker<Void, Void>{
	
	private JFrame frame;
	private JPanel pane;
	private CalendarPanel panel;
	private ArrayList<Event> events;
	private ArrayList<Event> notifications;
	
	public UpdateSwingWorker(JPanel pane, JFrame frame, CalendarPanel panel){
		this.frame = frame;
		this.pane = pane;
		this.panel = panel;
	}

	@Override
	public Void doInBackground() {
		while (true) {
//			System.out.println("it's working!");
			events = new ArrayList<Event>();
			notifications = new ArrayList<Event>();
			events = ((MainCalendarPanel) pane).requestCalendar(((MainCalendarPanel) pane).getPerson().getUsername()).getEventList();
			panel.getModel().addEvents(events);
			
			notifications = ((MainCalendarPanel) pane).requestNotifications();
			if (notifications != null) {
				//JOptionPane.showConfirmDialog(null, message, title, optionType);
				//JOptionPane.showMessageDialog(null, "Testing 1..2..3..");
			}
			
			try {
				//Sleeping for 20 seconds
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void done() {
		
	}
}
