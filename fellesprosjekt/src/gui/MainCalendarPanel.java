package gui;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import datapackage.CalendarRequestPackage;

import net.PackageSender;

import model.EventModel;

public class MainCalendarPanel extends JPanel {
	
	PackageSender sender;
	
	public MainCalendarPanel(String username){
		CalendarRequestPackage calReq = new CalendarRequestPackage(username,null);
		try {
			sender = new PackageSender();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not connect to server. Critical");
			e.printStackTrace();
		}
		sender.sendPackage(calReq);
		
		EventModel model = new EventModel(null, null);
		EventPanel eventPanel = new EventPanel(model);
		add(eventPanel);
		
		
		
	}
}
