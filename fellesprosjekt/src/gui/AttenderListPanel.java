package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

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
//	private InviteListModel inviteModel;
	
	public AttenderListPanel(EventModel model){
		this.model = model;
		
		ArrayList<HaveCalendar> hcs = model.getAttenders();
		
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
				HaveCalendar selected = (HaveCalendar) list.getSelectedValue();
				model.removeAttender(selected);
				
			}
		});
	}

	private void createList(ArrayList<HaveCalendar> hcs) {
		listModel = new DefaultListModel();
		list = new JList(); 
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(listModel);
		
		Collections.sort(hcs);
		for (HaveCalendar hc : hcs){
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
