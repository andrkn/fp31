package gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import datapackage.DataPackage;
import datapackage.ErrorPackage;
import datapackage.NotificationPackage;
import datapackage.RSVPPackage;

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
			for (DataPackage pack : notifications) {
				if (((NotificationPackage) pack).getNotificationType() == 0) {
					//I think this works now, but needs testing.
					JOptionPane.showMessageDialog(null, "The event " + ((NotificationPackage) pack).getEventName() + " is cancelled. Press OK to continue.");
				}
			}
			if (notifications != null) {
				for (Event e : events) {
					for (DataPackage pack : notifications) {
						if (((NotificationPackage) pack).getEventId() == e.getEventId()) {
							if (((NotificationPackage) pack).getNotificationType() == 1) {
								//Do like this to retrive the answer from the user.
								int answer = JOptionPane.showConfirmDialog(null, "The event " + e.getName() + " was updated. Are you still able to join?", "Your event was updated", JOptionPane.YES_NO_CANCEL_OPTION); 
								
								if (answer == JOptionPane.YES_OPTION) {
									DataPackage response = ((MainCalendarPanel) pane).sendPackage(new RSVPPackage(1,1,e.getEventId(),true, ((MainCalendarPanel) pane).getPerson().getUsername()));
									System.out.println(((ErrorPackage)response).getDescription());
								}
								else if (answer == JOptionPane.NO_OPTION) {
									DataPackage response = ((MainCalendarPanel) pane).sendPackage(new RSVPPackage(1,1,e.getEventId(),false, ((MainCalendarPanel) pane).getPerson().getUsername()));
									System.out.println(((ErrorPackage)response).getDescription());
								}
							}
							else if (((NotificationPackage) pack).getNotificationType() == 2) {
								int answer = JOptionPane.showConfirmDialog(null, "You are invited to the event " + e.getName() + ". Do you want to join?", "Your are invited", JOptionPane.YES_NO_CANCEL_OPTION); 
							
								if(answer == JOptionPane.YES_OPTION) {
									DataPackage response = ((MainCalendarPanel) pane).sendPackage(new RSVPPackage(1,1,e.getEventId(),true, ((MainCalendarPanel) pane).getPerson().getUsername()));
									System.out.println(((ErrorPackage)response).getDescription());
								}
								else if (answer == JOptionPane.NO_OPTION) {
									DataPackage response = ((MainCalendarPanel) pane).sendPackage(new RSVPPackage(1,1,e.getEventId(),false, ((MainCalendarPanel) pane).getPerson().getUsername()));
									System.out.println(((ErrorPackage)response).getDescription());
								}
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
