package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Room;
import model.RoomListModel;

public class RoomPanel extends JPanel{
	
	private RoomListModel rlm;
	private RoomList roomList;
	private JTextField placeField;
	
	public RoomPanel(RoomListModel rlm){
		super(new GridBagLayout());
		
		this.rlm = rlm;
		
		addRoomList(rlm); 
		addPlaceTextField();
		addButton();
	}

	private void addButton() {
		GridBagConstraints grid = new GridBagConstraints(); 
		grid.gridy = 2;
		grid.gridx = 0; 
		JButton pickRoom = new JButton("OK");
		
		pickRoom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(roomList.getSelectedValue().getClass());
				if (roomList.getSelectedValue() == null){
					rlm.setRoom(null);
					rlm.setPlace(placeField.getText());
				}else {
					rlm.setRoom((Room)roomList.getSelectedValue());
				}
			}
		});
		pickRoom.setVisible(true);
		this.add(pickRoom, grid);
		revalidate();
	}

	private void addRoomList(RoomListModel rlm) {
		roomList = new RoomList(rlm); 
		GridBagConstraints grid = new GridBagConstraints(); 
		grid.gridx = 0; 
		grid.gridy = 0; 
		
		this.add(roomList, grid);
	}
	
	private void addPlaceTextField(){
		placeField = new JTextField();
		GridBagConstraints grid = new GridBagConstraints(); 
		grid.gridx = 0; 
		grid.gridy = 1;
		grid.fill = GridBagConstraints.BOTH;
		
		this.add(placeField, grid);
	}
	
	
	
	
}
