package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.EventModel;

public class EventPreview extends JPanel implements PropertyChangeListener{
	
	private EventModel model;
	
	public EventPreview(EventModel model){
		this.model = model;
		model.addPropertyChangeListener(this);
		this.setLayout(new GridBagLayout());
		
		update();
		
	}

	private void update() {
		
		this.removeAll();
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridy = 0; 
		grid.gridx = 0; 
		grid.anchor = GridBagConstraints.FIRST_LINE_START; 
		grid.insets = new Insets(3, 3, 3, 3); 
		grid.ipady = 10; 
		
		JLabel nameLabel = new JLabel(model.getName());
		nameLabel.setFont(new Font("Serif", Font.BOLD, 14)); 
		this.add(nameLabel, grid); 
		
		grid.ipady = 0;
		
		grid.gridy += 1;
		JLabel roomLabel = new JLabel(model.getPlace());
		this.add(roomLabel, grid);

		grid.gridy += 1;
		JLabel numberOfAttendersLabel = new JLabel("Deltagere: " + model.getAttenders().size());
		this.add(numberOfAttendersLabel, grid);
		
		this.validate(); 
		this.repaint();
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		System.out.println("halla");
		update();
	}

}
