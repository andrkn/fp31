package model;

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

public class InviteListPanel extends JPanel{
	
	private GridBagConstraints grid;
	private JList list;
	private JButton addButton; 
	private DefaultListModel listModel; 
	
	public InviteListPanel(EventModel model){
		
		ArrayList<Person> persons = model.getInviteList();
		
		this.setLayout(new GridBagLayout());
		createList(persons);
		createButton();
		
		addComponents(); 
		
		this.setName("InviteListPanel");
	}

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
		addButton = new JButton("Legg til"); 
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}

	private void createList(ArrayList<Person> persons) {
		listModel = new DefaultListModel();
		list = new JList(); 
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(listModel);
		
		Collections.sort(persons);
		for (Person person : persons){
			listModel.addElement(person);
		}
	}

}
