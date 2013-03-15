package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.CalendarModel;

public class CalendarPanelWithLabels extends JPanel{
	
	private CalendarPanel calendarPanel;
	
	public CalendarPanelWithLabels(CalendarModel model){
		
		this.setLayout(new GridBagLayout());
		
		addDayLabel();
		addTimeLabel();
		addCalendar(model);
		
	}

	private void addCalendar(CalendarModel model) {
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 1; 
		grid.gridy = 1; 
		grid.gridwidth = 7;
		grid.gridheight = 24; 
		
		calendarPanel = new CalendarPanel(model);
		
		this.add(calendarPanel, grid);
		
		calendarPanel.setVisible(true);
	}

	private void addTimeLabel() {
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 0; 
		grid.gridy = 1; 
		
		for (int i = 0; i < 24; i++){
			this.add(getTimeLabel(i), grid); 
			grid.gridy += 1;
		}
	}
	
	private JLabel getTimeLabel(int time){
		return new JLabel(Integer.toString(time) + ":00");
	}

	private void addDayLabel() {
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 1; 
		grid.gridy = 0;
		
		JLabel mondayLabel = new JLabel("Mandag");
		this.add(mondayLabel, grid); 
		
		grid.gridx += 1; 
		JLabel tuesdayLabel = new JLabel("Tirsdag");
		this.add(tuesdayLabel, grid); 
		
		grid.gridx += 1; 
		JLabel wednesdayLabel = new JLabel("Onsdag");
		this.add(wednesdayLabel, grid); 
		
		grid.gridx += 1;
		JLabel thursdayLabel = new JLabel("Torsdag");
		this.add(thursdayLabel, grid); 
		
		grid.gridx += 1; 
		JLabel fridayLabel = new JLabel("Fredag");
		this.add(fridayLabel, grid); 
		
		grid.gridx += 1; 
		JLabel saturdayLabel = new JLabel("Lørdag");
		this.add(saturdayLabel, grid);
		
		grid.gridx += 1; 
		JLabel sundayLabel = new JLabel("Søndag");
		this.add(sundayLabel, grid);
	}
	
	public void update(){
		calendarPanel.update();
	}

}
