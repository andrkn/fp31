package gui;

import javax.swing.JPanel;

import model.EventModel;

public class MainCalendarPanel extends JPanel {
	
	public MainCalendarPanel(){
		EventModel model = new EventModel(null, null);
		EventPanel eventPanel = new EventPanel(model);
		add(eventPanel);
		
		
	}
}