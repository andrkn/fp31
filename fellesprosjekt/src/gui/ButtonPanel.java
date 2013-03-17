package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	private JButton addEvent, addExternalCal;
	private MainCalendarPanel mainPanel
	
	public ButtonPanel(MainCalendarPanel mainPanel){
		this.mainPanel = mainPanel;
		
		addEvent = new JButton("New event");
		addEvent.setName("NewEvent");
		addEvent.addActionListener(new ButtonPanelAction());
		add(addEvent);
		
		addExternalCal = new JButton("Import another persons calendar");
		addExternalCal.setName("AddExternal");
		addExternalCal.addActionListener(new ButtonPanelAction());
		add(addExternalCal);
	}
	public class ButtonPanelAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton sourceButton = (JButton)e.getSource();
			
			if (sourceButton.getName().equals("NewEvent")){
				System.out.println("Adding Event");
				mainPanel.newEvent();
				
			}
			else if (sourceButton.getName().equals("AddExternal")){
				System.out.println("Adding External Calendar");
			}
		}
		
	}
}

