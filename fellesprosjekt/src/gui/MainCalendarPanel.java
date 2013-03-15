package gui;

import java.awt.Dimension;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import datapackage.CalendarRequestPackage;
import datapackage.DataPackage;
import datapackage.EventPackage;

import net.PackageSender;

import model.Event;
import model.EventModel;
import model.HaveCalendar;
import model.Person;

public class MainCalendarPanel extends JPanel {

	PackageSender sender;

	public MainCalendarPanel(String username){
		CalendarRequestPackage calReq = new CalendarRequestPackage(username,null,1,1);
		try {
			sender = new PackageSender();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not connect to server. Critical");
			e.printStackTrace();
		}
		sender.sendPackage(calReq);
		ArrayList<DataPackage> response = sender.receivePackageArray();
		ArrayList<Event> eventList = new ArrayList<Event>();
		for (int i = 0; i<response.size();i++){
			if (response.get(i) instanceof EventPackage){
				EventPackage ePack = (EventPackage)response.get(i);
				eventList.add(ePack.getEvent());
			}
		}
		for (int j = 0; j<eventList.size(); j++){
			System.out.println("Got eventID: " + eventList.get(j).getEventId());
		}
		//eventList now contains all events for the username requested!
		
		this.setPreferredSize(new Dimension(800, 800));
		Person p = new Person();
		p.setName("Torstein");
		ArrayList<HaveCalendar> test = new ArrayList<HaveCalendar>();
		EventModel model = new EventModel(
				new Event(99, new Person(), new Timestamp(System.currentTimeMillis()), 
						new Timestamp(System.currentTimeMillis()), 
						"Name", "Decription", "Place", null, test), p);
		EventPanel eventPanel = new EventPanel(model);
		add(eventPanel);
		model.setEditeble(true);
		

		
	}
}
