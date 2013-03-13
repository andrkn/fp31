package gui;

import javax.swing.JPanel;

import datapackage.CalendarRequestPackage;

import net.PackageSender;

import model.EventModel;

public class MainCalendarPanel extends JPanel {
	
	PackageSender sender = new PackageSender();
	
	public MainCalendarPanel(String username){
		CalendarRequestPackage calReq = new CalendarRequestPackage(hc)
		
		EventModel model = new EventModel(null, null);
		EventPanel eventPanel = new EventPanel(model);
		add(eventPanel);
		
		
		
	}
}
