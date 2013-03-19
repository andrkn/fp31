package gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import datapackage.DataPackage;
import datapackage.NotificationPackage;

import model.Event;


public class UpdateSwingWorker extends SwingWorker<Void, Void>{
	
	private JFrame frame;
	private JPanel pane;
	private CalendarPanel panel;
	private ArrayList<Event> events;
	private ArrayList<DataPackage> notifications;
	
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
			notifications = new ArrayList<DataPackage>();
			events = ((MainCalendarPanel) pane).requestCalendar(((MainCalendarPanel) pane).getPerson().getUsername()).getEventList();
			panel.getModel().addEvents(events);
			
			notifications = ((MainCalendarPanel) pane).requestNotifications();
			if (notifications != null) {
				for (Event e : events) {
					for (DataPackage pack : notifications) {
						if (((NotificationPackage) pack).getEventId() == e.getEventId()) {
							if (((NotificationPackage) pack).getNotificationType() == 0) {
								//This will not work properly because the event won't show up in the list of events.
								//Need to check if the id is not in the events..
								JOptionPane.showMessageDialog(null, "The event " + e.getName() + " is cancelled. Press OK to continue.");
							}
							else if (((NotificationPackage) pack).getNotificationType() == 1) {
								int answer = JOptionPane.showConfirmDialog(null, "The event " + e.getName() + " was updated. Are you still able to join?", "Your event was updated", JOptionPane.YES_NO_CANCEL_OPTION); 
								//Do like this to retrive the answer from the user.
								if (answer == JOptionPane.YES_OPTION) {
									
								}
							}
							else if (((NotificationPackage) pack).getNotificationType() == 2) {
								int answer = JOptionPane.showConfirmDialog(null, "You are invited to the event " + e.getName() + ". Do you want to join?", "Your are invited", JOptionPane.YES_NO_CANCEL_OPTION); 
							
							}
						}
					}
				}
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
