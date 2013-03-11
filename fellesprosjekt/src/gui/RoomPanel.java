package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Room;
import model.RoomListModel;

public class RoomPanel extends JPanel{
	
	private GridBagConstraints grid; 
	private RoomListModel rlm;
	private RoomList roomList;
	
	public RoomPanel(RoomListModel rlm){
		super(new GridBagLayout());
		grid = new GridBagConstraints(); 
		
		this.rlm = rlm;
		
		addRoomList(rlm); 
		addButton();
	}

	private void addButton() {
		grid.gridy = 0;
		grid.gridx = 1; 
		JButton pickRoom = new JButton("OK");
		
		pickRoom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(roomList.getSelectedValue().getClass());
				rlm.setRoom((Room)roomList.getSelectedValue());
			}
		});
		pickRoom.setVisible(true);
		this.add(pickRoom, grid);
		revalidate();
	}

	private void addRoomList(RoomListModel rlm) {
		roomList = new RoomList(rlm); 
		grid.gridx = 0; 
		grid.gridy = 0; 
		
		this.add(roomList, grid);
	}
	
	
}
