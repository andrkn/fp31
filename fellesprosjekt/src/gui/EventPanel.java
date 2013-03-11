package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import model.EventModel;

public class EventPanel extends JPanel {
	
	GridBagConstraints grid;
	EventModel model;
	
	JTextField nameField; 
	JTextField startTimeField; 
	JTextField endTimeField;
	JTextField placeField; 
	JTextField descriptionField;
	JTextField alarmField;
	
	public EventPanel(EventModel model){
		
		this.model = model;
		grid = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		addLabels(); 
		addTextFields();
		setTittel();
		
	}
	
	public void setEditeble(){
		boolean editeble = model.getEditable(); 
		if (editeble == false){
			nameField.setEditable(false); 
			nameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			
			startTimeField.setEditable(false); 
			startTimeField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			
			endTimeField.setEditable(false); 
			endTimeField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			
			placeField.setEditable(false); 
			placeField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			
			descriptionField.setEditable(false); 
			descriptionField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			
			alarmField.setEditable(false); 
			alarmField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}else{
			Border border = (new JTextField()).getBorder();
			
			nameField.setEditable(true); 
			nameField.setBorder(border);
			
			startTimeField.setEditable(true); 
			startTimeField.setBorder(border);
			
			endTimeField.setEditable(true); 
			endTimeField.setBorder(border);
			
			placeField.setEditable(true); 
			placeField.setBorder(border);
			
			descriptionField.setEditable(true); 
			descriptionField.setBorder(border);
			
			alarmField.setEditable(true); 
			alarmField.setBorder(border);
		}
	}

	private void setTittel() {
		grid.gridx = 0; 
		grid.gridy = 0; 
		grid.gridwidth = 2; 
		grid.insets = new Insets(5, 5, 7, 5);
		grid.anchor = GridBagConstraints.CENTER;
		
		nameField = new JTextField(); 
		nameField.setText(model.getName());
//		nameField.setEditable(model.getEditable()); 
//		nameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.add(nameField, grid);
		
	}

	private void addTextFields() {
		//Setup of grid
		grid.gridx = 1;
		grid.gridy = 1; 
		grid.gridwidth = 1;
		grid.insets = new Insets(5,5,5,0);
		grid.anchor = GridBagConstraints.EAST;
		
		startTimeField = new JTextField(); 
		startTimeField.setText(model.getStartTime());
//		startTimeField.setEditable(model.getEditable());
		this.add(startTimeField, grid); 
		
		grid.gridy += 1; 
		endTimeField = new JTextField(); 
		endTimeField.setText(model.getEndTime()); 
//		endTimeField.setEditable(model.getEditable()); 
		this.add(endTimeField, grid);
		
		grid.gridy += 1; 
		placeField = new JTextField(); 
		placeField.setText(model.getPlace()); 
//		placeField.setEditable(model.getEditable()); 
		this.add(placeField, grid); 
		
		grid.gridy += 1; 
		descriptionField = new JTextField();
		descriptionField.setText(model.getDescription()); 
//		descriptionField.setEditable(model.getEditable()); 
		this.add(descriptionField, grid); 
		
		//Vise deltagere, ikke implimentert 
		grid.gridy += 1; 

		grid.gridy += 1;
		alarmField = new JTextField(); 
		alarmField.setText("20"); 
//		alarmField.setEditable(model.getEditable()); 
		this.add(alarmField, grid);
		
	}

	private void addLabels() {
		//Setup of grid
		grid.gridx = 0;
		grid.gridy = 1; 
		grid.gridwidth = 1;
		grid.insets = new Insets(5,0,5,5);
		grid.anchor = GridBagConstraints.WEST;
		
		
		//Add labels
		JLabel startTimeLabel = new JLabel("Fra: "); 
		this.add(startTimeLabel, grid); 
		
		grid.gridy += 1; 
		JLabel endTimeLabel = new JLabel("Til: "); 
		this.add(endTimeLabel, grid);
		
		grid.gridy += 1; 
		JLabel placeLabel = new JLabel("Sted: ");
		this.add(placeLabel, grid); 
		
		grid.gridy += 1; 
		JLabel descriptionLabel = new JLabel("Detaljer: ");
		this.add(descriptionLabel, grid); 
		
		grid.gridy += 1; 
		JLabel attendersLabel = new JLabel("Deltagere: "); 
		this.add(attendersLabel, grid); 
		
		grid.gridy += 1; 
		JLabel alarmLabel = new JLabel("Alarm: "); 
		this.add(alarmLabel, grid); 
	}

}
