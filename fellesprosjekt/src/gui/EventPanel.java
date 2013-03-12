package gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.EventModel;
import model.InviteListPanel;
import model.Person;

public class EventPanel extends JPanel implements PropertyChangeListener{
	
	private GridBagConstraints grid;
	private EventModel model;
	
	private JTextField nameField; 
	private JTextField startTimeField; 
	private JTextField endTimeField;
	private JTextField placeField; 
	private JTextField descriptionField;
	private JTextField alarmField;
	private int[] attendersGridConstants = new int[2];
	
	public EventPanel(EventModel model){
		
		this.model = model;
		
		this.setLayout(new GridBagLayout());
		
		addLabels(); 
		addTextFields();
		addTittel();
		addButtons();
		
		setEditeble();
		
	}
	
	private void addButtons() {
		// TODO Auto-generated method stub
		
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
			
			fixAttendersEditeble(true);
			
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
			
			fixAttendersEditeble(true);
		}
	}

	private void fixAttendersEditeble(boolean editeble) {
		for (Component comp : this.getComponents()){
			if(comp.getName() == null){
				continue;
				
			}else if (comp.getName().equals("AttendersList")){
				setupGridForComponents(); 
				this.remove(comp); 
				
				grid.gridx = attendersGridConstants[0]; 
				grid.gridy = attendersGridConstants[1]; 
				
				this.add(new InviteListPanel(model),grid);
				System.out.println("Added InviteListPanel");
				break;
				
			}else if(comp.getName().equals("InviteListPanel")){
				
				
				setupGridForComponents(); 
				this.remove(comp);
				
				grid.gridx = attendersGridConstants[0]; 
				grid.gridy = attendersGridConstants[1]; 
				
				this.add(getAttenders(), grid);
				System.out.println("Added attendersList");
				
				break; 
			}else {
				System.out.println("lol");
			}
		}
		this.validate();
		this.repaint();
	}

	private void addTittel() {
		grid = new GridBagConstraints();
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
		setupGridForComponents();
		
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
		JList attendersJList = getAttenders();
//		JPanel invitePanel = new InviteListPanel(model, model.getInviteList());
		int height = attendersJList.getHeight()+(new JButton()).getHeight();
		this.add(attendersJList,grid);
		attendersGridConstants[0] = grid.gridx;
		attendersGridConstants[1] = grid.gridy;
		grid.ipady = 0;
		

		grid.gridy += 1;
		alarmField = new JTextField(); 
		alarmField.setText("20"); 
//		alarmField.setEditable(model.getEditable()); 
		this.add(alarmField, grid);
		
		
	}

	private void setupGridForComponents() {
		grid = new GridBagConstraints();
		grid.gridx = 1;
		grid.gridy = 1; 
		grid.gridwidth = 1;
		grid.insets = new Insets(5,5,5,0);
		grid.anchor = GridBagConstraints.LINE_START;
		grid.fill = GridBagConstraints.BOTH;
	}

	private JList getAttenders() {
		JList attendersList = new JList();
		DefaultListModel listModel = new DefaultListModel(); 
		attendersList.setModel(listModel);

		ArrayList<Person> attendersArray = model.getAttenders();
		Collections.sort(attendersArray);
		for(Person person : attendersArray){
			listModel.addElement(person); 
		}
		
		attendersList.setName("AttendersList");
		
		return attendersList;
	}

	
	private void addLabels() {
		//Setup of grid
		grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 1; 
		grid.gridwidth = 1;
		grid.insets = new Insets(5,0,5,5);
		grid.anchor = GridBagConstraints.FIRST_LINE_START;
		
		
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

	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}

}
