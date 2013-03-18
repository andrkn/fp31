package gui;

import java.awt.Component;
import java.awt.Dimension;
import model.Event;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import datapackage.DataPackage;
import datapackage.ErrorPackage;
import datapackage.EventPackage;
import datapackage.EventUpdatePackage;

import model.EventModel;
import model.HaveCalendar;
import model.InviteListPanel;
import model.Person;

public class EventPanel extends JPanel implements PropertyChangeListener{
	
	private GridBagConstraints grid;
	private EventModel model;
	private Person user;
	
	private JTextField nameField; 
	private JTextField startTimeField; 
	private JTextField endTimeField;
	private JTextField placeField; 
	private JTextField descriptionField;
	private JTextField alarmField;
	private int[] attendersGridConstants = new int[2];
	private int endRow;
	private int alarmOption;
	private MainCalendarPanel mainCalendarPanel;
	
	public EventPanel(EventModel model, MainCalendarPanel mainCalendarPanel){
		this.mainCalendarPanel = mainCalendarPanel;
		this.model = model;
		model.addPropertyChangeListener(this);
		
		this.setLayout(new GridBagLayout());
		
		model.setEditeble(true);
		
//		addLabels(model.getEditable()); 
//		addTextFields(model.getEditable());
//		addTittel(model.getEditable());
//		addButtons();
		
		//launchAlarm(model.getEvent());
		setEditeble();
		
		
	}
	
//	public void setEditeble(){
//		boolean editeble = model.getEditable();
//		
//		setEditebleTextField(nameField, editeble);
//		setEditebleTextField(startTimeField, editeble);
//		setEditebleTextField(endTimeField, editeble);
//		setEditebleTextField(placeField, editeble);
//		setEditebleTextField(descriptionField, editeble);
//		setEditebleTextField(alarmField, editeble);
//		
//		fixAttendersEditeble(editeble);
//	}
	public void setEditeble(){
		this.removeAll();
		
		boolean editeble = model.getEditable(); 
		

		addLabels(editeble); 
		addTextFields(editeble); 
		addTittel(editeble); 
		addEventButtonPanel(editeble);
		
		this.validate();
		this.repaint();
	}
	
	private void setEditebleTextField(JTextField field, boolean editeble){
		if (!editeble){
			Border border = (new JTextField()).getBorder();
			field.setEditable(true); 
			field.setBorder(border);
		}else{
			field.setEditable(false); 
			field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
	}

//	private void fixAttendersEditeble(boolean editeble) {
//		for (Component comp : this.getComponents()){
//			System.out.println(comp);
//			if(comp.getName() == null){
//				continue;
//				
//			}else if (comp.getName().equals("AttenderListPanel") && editeble == false){
//				setupGridForComponents(); 
//				this.remove(comp); 
//				
//				grid.gridx = attendersGridConstants[0]; 
//				grid.gridy = attendersGridConstants[1]; 
//				
//				this.add(new InviteListPanel(model),grid);
//				System.out.println("Added InviteListPanel");
//				break;
//				
//			}else if(comp.getName().equals("InviteListPanel") && editeble == true){
//				
//				
//				setupGridForComponents(); 
//				this.remove(comp);
//				
//				grid.gridx = attendersGridConstants[0]; 
//				grid.gridy = attendersGridConstants[1]; 
//				
//				this.add(getAttenders(), grid);
//				System.out.println("Added attendersList");
//				
//				break; 
//			}else {
////				System.out.println("lol");
//			}
//		}
//		this.validate();
//		this.repaint();
//	}
	public EventModel getModel(){
		return this.model;
	}
	
	public void setModel(EventModel model){
		this.model = model;
		setEditeble();
	}
	
	private void addTittel(boolean editeble) {
		setupGridForSpan2();
		
		nameField = new JTextField(); 
		nameField.setText(model.getName());
		nameField.setName("NameField");
		nameField.setColumns(15);
		setEditebleTextField(nameField, editeble);
//		nameField.setEditable(model.getEditable()); 
//		nameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.add(nameField, grid);

	}

	private void setupGridForSpan2() {
		grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridwidth = 2;
		grid.insets = new Insets(5, 5, 7, 5);
		grid.anchor = GridBagConstraints.CENTER;
	}

	private void addEventButtonPanel(boolean editeble) {
		setupGridForSpan2();
		grid.gridy = endRow;
		this.add(new EventButtonPanel(this, editeble), grid);
	}

	private void addTextFields(boolean editeble) {
		//Setup of grid
		setupGridForComponents();
		
		startTimeField = new JTextField(); 
		startTimeField.setText(model.getStartTime());
		startTimeField.setName("StartTimeField");
		startTimeField.setColumns(15);
		setEditebleTextField(startTimeField, editeble);
		this.add(startTimeField, grid);

		grid.gridy += 1;
		endTimeField = new JTextField();
		endTimeField.setText(model.getEndTime());
		endTimeField.setColumns(15);
		setEditebleTextField(endTimeField, editeble);
		this.add(endTimeField, grid);

		grid.gridy += 1;
		if (!editeble) {
			JPanel roomPanel = new RoomPanel(model.getRoomListModel());
			this.add(roomPanel, grid);

		} else {
			placeField = new JTextField();
			placeField.setText(model.getPlace());
			placeField.setName("PlaceField");
			setEditebleTextField(placeField, editeble);
			this.add(placeField, grid);
		}

		grid.gridy += 1;
		descriptionField = new JTextField();
		descriptionField.setText(model.getDescription());
		descriptionField.setName("DescriptionField");
		descriptionField.setPreferredSize(new Dimension(120,60));
		setEditebleTextField(descriptionField, editeble);
		this.add(descriptionField, grid); 
		
		//Vise deltagere, ikke implimentert 
		grid.gridy += 1; 
		Component attenderComponent;
		if(!editeble){
			attenderComponent = new AttenderListPanel(model);
			
		}else{
			
				attenderComponent = getAttenders();

			
		}
//		int height = attenderComponent.getHeight()+(new JButton()).getHeight();
		this.add(attenderComponent,grid);
		attendersGridConstants[0] = grid.gridx;
		attendersGridConstants[1] = grid.gridy;
		grid.ipady = 0;
		
		//inviteRow
		grid.gridy += 1;
		if(!editeble){
			JPanel invitePanel = new InviteListPanel(model); 
			this.add(invitePanel, grid);
		}
		

		grid.gridy += 1;
		alarmField = new JTextField(); 
		//alarmField.setText(model.getAlarm()); 
		alarmField.setName("AlarmField");
		setEditebleTextField(alarmField, editeble);
		this.add(alarmField, grid);
		
		
		grid.gridy += 1; 
		JLabel numberOfAttendersField = new JLabel(Integer.toString(model.getNumberOfAttenders())); 
		numberOfAttendersField.setName("NumberOfAttendersField"); 
		this.add(numberOfAttendersField, grid); 
		
		grid.gridy += 1; 
		JLabel numberOfNotAnswardField = new JLabel(Integer.toString(model.getNumberOfNotAnsward())); 
		numberOfNotAnswardField.setName("NumberOfNotAnswardField");
		this.add(numberOfNotAnswardField, grid); 
		
		grid.gridy += 1; 
		JLabel numberOfDeclinesField = new JLabel(Integer.toString(model.getNumberOfDeclines()));
		numberOfDeclinesField.setName("NumberOfDeclinesField");
		this.add(numberOfDeclinesField, grid);
		
		
		endRow = grid.gridy+1;
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
		ArrayList<HaveCalendar> attendersArray = model.getAttenders();
		//Null-check
		if (attendersArray == null){
			ArrayList<HaveCalendar> nullCheckArray = new ArrayList<HaveCalendar>();
			attendersArray = nullCheckArray;
		}
		
		Collections.sort(attendersArray);
		for(HaveCalendar hc : attendersArray){
			listModel.addElement(hc); 
		}
		
		attendersList.setName("AttendersList");
		
		return attendersList;
	}

	
	private void addLabels(boolean editeble) {
		//Setup of grid
		setupForGridLabel();
		
		
		//Add labels
		JLabel startTimeLabel = new JLabel("Fra: "); 
		startTimeLabel.setName("StartTimeLabel");
		this.add(startTimeLabel, grid); 
		
		grid.gridy += 1; 
		JLabel endTimeLabel = new JLabel("Til: ");
		endTimeLabel.setName("EndTimeLabel");
		this.add(endTimeLabel, grid);
		
		grid.gridy += 1; 
		JLabel placeLabel = new JLabel("Sted: ");
		placeLabel.setName("PlaceLabel");
		this.add(placeLabel, grid); 
		
		grid.gridy += 1; 
		JLabel descriptionLabel = new JLabel("Detaljer: ");
		descriptionLabel.setName("DescriptionLabel");
		this.add(descriptionLabel, grid); 
		
		grid.gridy += 1; 
		JLabel attendersLabel = new JLabel("Deltagere: ");
		attendersLabel.setName("AttendersLabel");
		this.add(attendersLabel, grid); 
		
		//Row for invite list
		grid.gridy += 1; 
		if (!editeble){
			JLabel inviteLabel = new JLabel("Inviter"); 
			inviteLabel.setName("inviteLabel");
			this.add(inviteLabel,grid);
		}
		
		
		grid.gridy += 1; 
		JLabel alarmLabel = new JLabel("Alarm: "); 
		alarmLabel.setName("AlarmLabel");
		this.add(alarmLabel, grid); 
		
		grid.gridy += 1; 
		JLabel numberOfAttendersLabel = new JLabel("Godtatt invitasjon: "); 
		numberOfAttendersLabel.setName("NumberOfAttendersLabel"); 
		this.add(numberOfAttendersLabel, grid); 
		
		grid.gridy += 1; 
		JLabel numberOfNotAnswardLabel = new JLabel("Ikke svart: "); 
		numberOfNotAnswardLabel.setName("NumberOfNotAnswardLabel");
		this.add(numberOfNotAnswardLabel, grid); 
		
		grid.gridy += 1; 
		JLabel numberOfDeclinesLabel = new JLabel("Avsl�tt invitasjon: ");
		numberOfDeclinesLabel.setName("NumberOfDeclinesLabel");
		this.add(numberOfDeclinesLabel, grid);
	}

	private void setupForGridLabel() {
		grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 1; 
		grid.gridwidth = 1;
		grid.insets = new Insets(5,0,5,5);
		grid.anchor = GridBagConstraints.FIRST_LINE_START;
	}

	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		setEditeble();
	}
	
	public void save(){
		
		model.setName(nameField.getText()); 
		model.setDescription(descriptionField.getText());
		model.setStartTime(startTimeField.getText()); 
		model.setEndTime(endTimeField.getText());
		if (alarmField.getText().equals("")){
			model.setAlarm(0);
		}else{
			model.setAlarm(Integer.parseInt(alarmField.getText()));
		}
		
		Event returnEvent = model.getEvent();
		EventPackage eventPack = new EventPackage(1, 1, returnEvent);
		DataPackage returnPack = mainCalendarPanel.sendPackage(eventPack);
		if (returnPack instanceof EventPackage){
			model.getEvent().setEventId(((EventPackage) returnPack).getEvent().getEventId());
			System.out.println(((EventPackage)returnPack).getEvent().getEventId());
		}
		else if (returnPack instanceof ErrorPackage){
			System.out.println(((ErrorPackage)returnPack).getDescription());
		}
		
		model.setEditeble(true);
	}
	public void abort(){
		model.setEditeble(true); 
	}
	public void change(){
		model.setEditeble(false);
	}
	public void delete(){
		EventUpdatePackage pack = new EventUpdatePackage(model.getEvent().getEventId(), "Delete", null, 1, 1);
		
		mainCalendarPanel.sendPackage(pack);
	}
	
	public void launchAlarm(Event e) {
		
		String msgString = "Det er et oppkommende møte i rom: " + e.getPlace()
							+ "\nklokken: " + e.getStartTime() + 
							"\nfor følgende personer:" + e.getAttenders();
		JOptionPane.showConfirmDialog(mainCalendarPanel, msgString);
				
		
				
	}

}
