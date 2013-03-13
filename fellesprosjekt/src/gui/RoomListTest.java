package gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.CalendarModel;
import model.Event;
import model.HaveCalendar;
import model.Person;
import model.Room;
import model.RoomListModel;
import gui.RoomPanel;

public class RoomListTest {
	
	ArrayList<Room> roomArray;
	RoomListModel rlm; 
	
	public static void main(String[] args) {
		(new RoomListTest()).test();
	}
	
	private void test(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(); 
		
		roomArray = new ArrayList<Room>();
		roomArray.add(new Room("100",40));
		roomArray.add(new Room("110",19));
		roomArray.add(new Room("101",5));
		
		Event event = new Event(0, null, null, null, null, null, null, null, null);
		event.addAttender(new Person());
		event.addAttender(new Person());
		event.addAttender(new Person());
		event.addAttender(new Person());
		event.addAttender(new Person());
		event.addAttender(new Person());
		event.addAttender(new Person());
		
		rlm = new RoomListModel(roomArray, event);
		
		
		
		RoomPanel roomPanel = new RoomPanel(rlm);
		panel.add(roomPanel);
		
		frame.setContentPane(panel);
		frame.setSize(400, 900);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
	}

}
