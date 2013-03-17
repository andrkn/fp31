package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.CalendarModel;

public class CalendarPanelWithLabels extends JPanel{
	
	private CalendarPanel calendarPanel;
	private int width = 1400; 
	private int height = 900;
	
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
		
		calendarPanel = new CalendarPanel(model,null);
		
		this.add(calendarPanel, grid);
		
		Dimension dim = new Dimension(width,height);
		calendarPanel.setMinimumSize(dim);
		calendarPanel.setPreferredSize(dim);
		calendarPanel.setMaximumSize(dim);
//		calendarPanel.setSize(dim);
		
		calendarPanel.setVisible(true);
	}

	private void addTimeLabel() {
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 0; 
		grid.gridy = 1; 
		grid.weightx = 1; 
		grid.weighty = 1; 
		
		
		for (int i = 0; i < 24; i++){
			this.add(getTimeLabel(i), grid); 
			grid.gridy += 1;
		}
	}
	
	private JLabel getTimeLabel(int time){
		return new JLabel(Integer.toString(time) + ":00");
	}

	private void addDayLabel() {
//		JPanel this = new JPanel(); 
		
		GridBagConstraints grid = new GridBagConstraints();
		
		grid.gridx = 1; 
		grid.gridy = 0;
		grid.weightx = 1; 
		grid.weighty = 1;
		
//		grid.insets = new Insets(0, 200, 0, 200); 
		
		
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
		
//		grid = new GridBagConstraints();
//		grid.gridx = 1; 
//		grid.gridy = 0; 
//		
//		this.add(this, grid);
//		
//		Dimension dim = new Dimension(width, 30);
//		this.setMinimumSize(dim);
//		this.setPreferredSize(dim);
//		this.setMaximumSize(dim);
	}
	
	public void update(){
		calendarPanel.update();
	}

}
