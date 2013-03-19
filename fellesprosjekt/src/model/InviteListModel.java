package model;

import gui.MainCalendarPanel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import net.DBMethods;

public class InviteListModel implements ListModel{
	//Her har jeg tenkt at vi handterer grupper og personer pa samme mate, men det er mulig dette b�re l�ses p� en annen m�te.
	//Dette gjelder da spesifikt sendInvite().	
	
	private ArrayList<HaveCalendar> inviteList;
	private PropertyChangeSupport pcs;
	private int eventId;
	private DefaultListModel dlm;
	private MainCalendarPanel mainPanel;

	
	public InviteListModel(MainCalendarPanel mainPanel, EventModel model, int eventID){
		this.eventId = eventID;
		this.mainPanel = mainPanel;
		dlm = new DefaultListModel();
		ArrayList<HaveCalendar> allInviteble = mainPanel.getInviteList();
		inviteList = new ArrayList<HaveCalendar>(); 
		for (HaveCalendar hc : allInviteble){
			if (!model.getAttenderList().contains(hc.toString())){
				inviteList.add(hc);
			}
		}
		Collections.sort(inviteList);
	}
	
//	public InviteListModel(int eventId) {
//		this.setEventId(eventId);
//		inviteList = new ArrayList<HaveCalendar>();
//	}
//	
//	public int getEventId() {
//		return eventId;
//	}
//
//	public void setEventId(int eventId) {
//		this.eventId = eventId;
//	}

	public void sendInvite(int eventId, ArrayList<HaveCalendar> list, DBMethods invite) throws SQLException {
		invite.invitePersons(eventId, list);
	}
	public void sendInvite(HaveCalendar hc){
		ArrayList<HaveCalendar> hcList = new ArrayList<HaveCalendar>();
		hcList.add(hc);
		mainPanel.sendInvite(eventId, hcList);
	}
	
//	public void addPropertyChangeListener(PropertyChangeListener listener) {
//		pcs.addPropertyChangeListener(listener);
//	}
//	
//	public void removePropertyChangeListener(PropertyChangeListener listener) {
//		pcs.removePropertyChangeListener(listener);
//	}
	
	public ArrayList<HaveCalendar> getInviteList() {
		return inviteList;
	}
	
//	public void setInviteList(ArrayList<HaveCalendar> inviteList) {
//		this.inviteList = inviteList;
//	}
	
	public void add(HaveCalendar hc) {
		this.inviteList.add(hc);
		dlm.addElement(hc);
		sendInvite(hc);
	}
	
//	public void addInvite(Group g) {
//		this.inviteList.add(g);
//	}
//	
//	public PropertyChangeSupport getPcs() {
//		return pcs;
//	}
//	
//	public void setPcs(PropertyChangeSupport pcs) {
//		this.pcs = pcs;
//	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		dlm.addListDataListener(arg0);
	}

	@Override
	public Object getElementAt(int arg0) {
		return inviteList.get(arg0);
	}

	@Override
	public int getSize() {
		return inviteList.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		dlm.removeListDataListener(arg0);
	}
	
	
}
