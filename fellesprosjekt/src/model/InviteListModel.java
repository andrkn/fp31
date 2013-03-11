package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class InviteListModel {

	private ArrayList<HaveCalendar> InviteList;
	private PropertyChangeSupport pcs;
	
	public void sendInvite() {
		for (HaveCalendar ob : InviteList) {
			
		}
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
