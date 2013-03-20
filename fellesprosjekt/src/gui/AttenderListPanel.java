package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import model.Event;
import model.EventModel;
import model.HaveCalendar;
import model.InviteListModel;
import model.Person;

public class AttenderListPanel extends JPanel{

	private GridBagConstraints grid;
	private JList list;
	private JButton addButton; 
	private DefaultListModel listModel; 
	private EventModel model;
	private HashMap<String, HaveCalendar> nameMap;
	private MainCalendarPanel mainPanel; 
	
	public AttenderListPanel(EventModel model, MainCalendarPanel mainCalendarPanel){
		this.model = model;
		this.mainPanel = mainCalendarPanel; 
		nameMap = new HashMap<String, HaveCalendar>(); 
		for (HaveCalendar hc : mainCalendarPanel.getInviteList()){
			nameMap.put(hc.getName(), hc);
		}
		
		ArrayList<String> hcs = model.getAttenderList();
		
		System.out.println("Creating attendersListPanel: ");
		System.out.println(model.getAttenderList() + "AttendersListPanel");
		
		this.setLayout(new GridBagLayout());
		createList(hcs);
		createButton();
		
		addComponents(); 
		
		this.setName("AttenderListPanel");
	}
	
//	public AttenderListPanel(InviteListModel model){
//		this.inviteModel = model; 
//		list = getJList();
//		createButton();
//	}

	private void addComponents() {
		grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 0; 
		grid.insets = new Insets(0, 0, 5, 0);
		grid.fill = GridBagConstraints.BOTH;
		
		this.add(list, grid); 
		
		grid.gridy += 1; 
		this.add(addButton, grid); 
		
	}

	private void createButton() {
		addButton = new JButton("Fjern"); 
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String selected = (String) list.getSelectedValue();
				model.removeAttender(nameMap.get(selected));
				mainPanel.removeAttender(selected, model.getEvent());
			}
		});
	}

	private void createList(ArrayList<String> hcs) {
		listModel = new DefaultListModel();
		list = new JList(); 
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(listModel);
		
		Collections.sort(hcs);
		for (String hc : hcs){
			listModel.addElement(hc);
		}
	}

//	private JList getJList(){
//		JList list = new JList();
//		listModel = new DefaultListModel();
//		list.setModel(listModel);
//		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		
//		return list;
//	}
}
