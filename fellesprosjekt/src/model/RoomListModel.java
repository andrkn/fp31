package model;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;

public class RoomListModel extends DefaultListModel<Room>{
	
	public RoomListModel(ArrayList<Room> roomList){
		Collections.sort(roomList);
		for (Room room : roomList){
			addElement(room);
		}
	}
	
//	public void setRoom(){
//		
//	}
}
