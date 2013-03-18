package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import datapackage.CalendarRequestPackage;
import datapackage.DataPackage;
import datapackage.EventPackage;

import net.PackageSender;

import model.CalendarModel;
import model.Event;
import model.EventModel;
import model.HaveCalendar;
import model.Person;
import model.Room;

public class MainCalendarPanel extends JPanel {

	private PackageSender sender;
	private EventPanel eventPanel;
	private Person user;
	private ArrayList<Event> eventList;
	private ArrayList<DataPackage> response;
	private CalendarPanel calendarPanel;
	private GridBagLayout gridbag;
	private GridBagConstraints gridbagConstraints;
	private CalendarModel calModel;
	
	
	public MainCalendarPanel(String username){
		//Set the current user. ATM does not care about anything but username
		user = new Person(username, "","");
		
		//Request the users calendar from DB
		calModel = requestCalendar(username);
		
		//construct the view
		Dimension dim = new Dimension(1300,900);
		this.setPreferredSize(dim);
		this.setMinimumSize(dim);
		ArrayList<HaveCalendar> test = new ArrayList<HaveCalendar>();
//		Person p = new Person();
//		p.setName("Torstein");
//		EventModel model = new EventModel(
//				new Event(99, new Person(), new Timestamp(System.currentTimeMillis()), 
//						new Timestamp(System.currentTimeMillis()), 
//						"Name", "Decription", "Place", null, test), p);
		EventModel model = new EventModel(calModel.getEventList().get(0), calModel.getEventList().get(0).getCreatedBy());
		System.out.println(model);
		
		gridbag = new GridBagLayout();
		gridbagConstraints = new GridBagConstraints();
		gridbagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridbagConstraints.insets = new Insets(1,1,1,1);
		this.setLayout(gridbag);
		
		eventPanel = new EventPanel(model, this);
		
		ButtonPanel buttonPanel = new ButtonPanel(this);
		
		calendarPanel = new CalendarPanel(calModel,this);
		calendarPanel.setVisible(true);
		Dimension dim2 = new Dimension(900,700);
		calendarPanel.setMinimumSize(dim2);
		calendarPanel.setMaximumSize(dim2);
		calendarPanel.setPreferredSize(dim2);
		calendarPanel.setSize(dim2);
		
		gridbagConstraints.gridx = 0;
		gridbagConstraints.gridy = 0;
		add(buttonPanel, gridbagConstraints);
		gridbagConstraints.gridx = 1;
		gridbagConstraints.gridy = 1;
		add(eventPanel, gridbagConstraints);
		gridbagConstraints.gridx = 0;
		gridbagConstraints.gridy = 1;
		add(calendarPanel, gridbagConstraints);
		model.setEditeble(true);
		calendarPanel.update();
		
		this.validate();
		this.repaint();
	}

	private CalendarModel requestCalendar(String username) {
		CalendarRequestPackage calReq = new CalendarRequestPackage(username,null,1,1);
		try {
			sender = new PackageSender();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not connect to server. Critical");
			e.printStackTrace();
		}
		sender.sendPackage(calReq);
		response = sender.receivePackageArray();
		eventList = new ArrayList<Event>();
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
		
		CalendarModel tempcalModel = new CalendarModel();
		tempcalModel.setEventList(eventList);
		return tempcalModel;
	}
	
	public void newEvent(){
		Event event = new Event(0,this.user,new Timestamp(0), new Timestamp(0),"","","",null,new ArrayList<HaveCalendar>());
		this.eventPanel.setModel(new EventModel(event, this.user));
	}
	
	public void setEvent(EventModel model){
		//Call this method if you need to change the event currently beeing viewed
		this.eventPanel.setModel(model);
	}
	
	public void importEvents(){
		/*Import antoher contacts events.
		 * needs to activate a view that lets the user enter a username
		 * and then send that username with a CalendarRequestPackage to
		 * the server.
		 */
	}

	public DataPackage sendPackage(DataPackage pack) {
		sender.sendPackage(pack);
		return sender.receivePackage();
	}

	public CalendarModel getCalModel() {
		return calModel;
	}

	public void setCalModel(CalendarModel calModel) {
		this.calModel = calModel;
		firePropertyChange("Update", 1, 1);
	}
	
	
	
}
