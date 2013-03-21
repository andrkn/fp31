package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.EventModel;

public class EventPreview extends JPanel implements PropertyChangeListener, MouseListener{
	
	private EventModel model;
	private MainCalendarPanel mainPanel;
	public static final Color backgroundColor = new Color(190,190,190); 
	private boolean mouseOver; 
	
	public EventPreview(EventModel model, MainCalendarPanel mainPanel){
		this.model = model;
		this.mainPanel = mainPanel;
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
		grid.ipady = 5; 
		
		JLabel nameLabel = new JLabel(model.getName());
		nameLabel.setFont(new Font("Serif", Font.BOLD, 14)); 
		this.add(nameLabel, grid); 
		
		grid.ipady = 0;
		
		grid.gridy += 1;
		JLabel roomLabel = new JLabel(model.getPlace());
		this.add(roomLabel, grid);

		grid.gridy += 1;
		JLabel numberOfAttendersLabel = new JLabel("Deltagere: " + model.getNumberOfAttenders());
		this.add(numberOfAttendersLabel, grid);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(backgroundColor);
		
		this.addMouseListener(this);
		
		this.validate(); 
		this.repaint();
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		update();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
			mainPanel.setEvent(model);
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
