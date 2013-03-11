package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import net.DBMethods;

public class InviteListModel {

	private ArrayList<HaveCalendar> InviteList;
	private PropertyChangeSupport pcs;
	private int eventId;
	
	public InviteListModel() {
		
	}
	
	public void sendInvite(int eventId, ArrayList<HaveCalendar> list) {
		DBMethods invite = new DBMethods();
		invite.invite(eventId, list);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	public ArrayList<HaveCalendar> getInviteList() {
		return InviteList;
	}
	
	public void setInviteList(ArrayList<HaveCalendar> inviteList) {
		InviteList = inviteList;
	}
	
	public PropertyChangeSupport getPcs() {
		return pcs;
	}
	
	public void setPcs(PropertyChangeSupport pcs) {
		this.pcs = pcs;
	}
	
	
}
