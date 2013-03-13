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

import model.EventModel;
import model.Person;

public class EventButtonPanel extends JPanel{
	
	private GridBagConstraints grid;
	private EventPanel panel;
	private JButton saveButton, abortButton, changeButton;
	
	public EventButtonPanel(EventPanel panel, boolean editeble){
		
		this.panel = panel;
		
		
		this.setLayout(new GridBagLayout());
		
		if (!editeble){
			createEditeblePanel();
		}else{
			createNoneEditeblePanel();
		}
	}

	private void createEditeblePanel() {
		setupGrid();
		
		createSaveButton();
		this.add(saveButton, grid); 
		
		grid.gridx += 1;
		createabortButton();
		this.add(abortButton, grid); 
		
	}
	
	private void createNoneEditeblePanel(){
		setupGrid(); 
		
		createchangeButton(); 
		this.add(changeButton, grid);
	}

	private void setupGrid() {
		grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 0; 
		grid.insets = new Insets(5, 5, 5, 5);
		grid.fill = GridBagConstraints.BOTH;
	}

	private void createSaveButton() {
		saveButton = new JButton("Lagre"); 
		saveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				panel.save(); 
			}
		});
	}
	
	private void createabortButton(){
		abortButton = new JButton("Avbryt");
		abortButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				panel.abort();
			}
		});
		
	}
	private void createchangeButton(){
		changeButton = new JButton("Endre"); 
		changeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				panel.change();
			}
		});
	}

	

}
