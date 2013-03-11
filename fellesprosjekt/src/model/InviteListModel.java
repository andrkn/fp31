package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;

import net.DBMethods;

public class InviteListModel {
	//Her har jeg tenkt at vi handterer grupper og personer pa samme mate, men det er mulig dette børe løses på en annen måte.
	//Dette gjelder da spesifikt sendInvite().	
	
	private ArrayList<HaveCalendar> InviteList;
	private PropertyChangeSupport pcs;
	private int eventId;
	
	public InviteListModel(int eventId) {
		this.setEventId(eventId);
		InviteList = new ArrayList<HaveCalendar>();
	}
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public void sendInvite(int eventId, ArrayList<HaveCalendar> list, DBMethods invite) throws SQLException {
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
	
	public void addInvite(Person p) {
		this.InviteList.add(p);
	}
	
	public void addInvite(Group g) {
		this.InviteList.add(g);
	}
	
	public PropertyChangeSupport getPcs() {
		return pcs;
	}
	
	public void setPcs(PropertyChangeSupport pcs) {
		this.pcs = pcs;
	}
	
	
}
