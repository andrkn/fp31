package net;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;


import model.Event;
import model.HaveCalendar;

public class DBMethods {
	
	private Connection connection = null;
	private Statement statement = null;
	
	public void setConnection(Connection con){
		connection = con;
	}
	
	public void setStatement(Statement statm){
		statement = statm;
	}
	
	public Event createEvent(String createdBy, Time startTime, Time endTime, String eventName, 
			String description, String place, String invitedPersons, String invitedGroups, String roomNr) throws SQLException{
		
		statement = connection.createStatement();
		String sql = "INSERT INTO Event (createdBy_username, startTime, endTime, eventName, " +
				"description, place, invitedPersons, invitedGroups, roomNr) VALUES ('"+ createdBy 
				+ "', '" + startTime + "', '" + endTime + "', '" + eventName + "', '" + description + "', '" +
						place + "', '" + invitedPersons + "', '" + invitedGroups + "', '" + roomNr + "')";
		statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = statement.getGeneratedKeys();
		resultSet.beforeFirst();
		resultSet.next();
		int eventId = resultSet.getInt(1);
		if (!invitedPersons.equals("")){
			for (String person : invitedPersons.split(" ")){
				updateInvited(person, eventId);
			}			
		}
		if(!invitedGroups.equals("")){
			for (String g : invitedGroups.split(" ")){
				String persons = getPersonsFromGroup(Integer.parseInt(g));
				for (String p : persons.split(" ")){
					updateInvited(p,eventId);
				}
			}
		}
		return new Event(eventId, createdBy,startTime,endTime,eventName, description,place,invitedPersons,invitedGroups,roomNr);
	}
	
	public String getPersonsFromGroup(int groupNr) throws SQLException{
		statement = connection.createStatement();
		String sql = "SELECT persons FROM `Group` WHERE groupID = " + groupNr; 
		ResultSet resultSet = statement.executeQuery(sql);
		String persons = "";
		resultSet.beforeFirst();
		while(resultSet.next()){
			persons += resultSet.getString("persons") + " ";
		}	
		return persons;
	}
	
	public void updateInvited(String username, int eventId) throws SQLException{
		statement = connection.createStatement();
		String sql = "INSERT INTO Invited (username, eventId) VALUES ('" + username + "', " + eventId + ")" ;
		statement.executeUpdate(sql);
	}
	
    public void createUser (String username, String email, String name,
    		byte [] salt, byte [] password)  throws Exception{
    	String sql = "INSERT INTO Person (username, password, name, email, salt)"
    			+ " VALUES ('" + username + "', ?, '" + name + "', '" + email + "', ?)";
 
    	PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
    	ps.setBytes(1, salt);
    	ps.setBytes(2, password);
    	ps.executeUpdate();
    	System.out.println("User created...");
    }
    
    public byte[] getStoredHash(String username, String collumnName) throws SQLException{
    	String sql = "SELECT * FROM Person WHERE username = '" + username +"'";
    	ResultSet resultSet = statement.executeQuery(sql);
    	resultSet.next();
    	byte[] hash = resultSet.getBytes(collumnName);
    	return hash;
    }
    

    public Event getEvent(int eventId) throws SQLException{
    	statement = connection.createStatement();
    	String sql = "SELECT * FROM Event WHERE eventID = " + eventId;
    	ResultSet resultSet = statement.executeQuery(sql);
    	resultSet.beforeFirst();
    	resultSet.next();
    	int id = resultSet.getInt(1);
    	String createdBy = resultSet.getString(2);
    	Time start = resultSet.getTime(3);
    	Time end = resultSet.getTime(4);
    	String eventName = resultSet.getString(5);
    	String description = resultSet.getString(6);
    	String place = resultSet.getString(7); 
    	String invitedPersons = resultSet.getString(8);
    	String invitedGroups = resultSet.getString(9);
    	String roomNr = resultSet.getString(10);
    	return new Event(id, createdBy, start, end, eventName, description, place, invitedPersons, invitedGroups, roomNr);
    }
    
    public void invite(int eventId, ArrayList<HaveCalendar> persons) throws SQLException{
    	for  (HaveCalendar p : persons){
    		updateInvited(p.getName(), eventId);
    	}
    }
    
    public void answerInvite(String username, int eventId, int isGoing) throws SQLException{
    	statement = connection.createStatement();
    	String sql = "UPDATE Invited SET isGoing =" + isGoing + " WHERE username = '" + username + "' "
    			+ "AND eventID = " + eventId;
    	statement.executeUpdate(sql);
    }
    
    public boolean isExcistingUser(String username) throws SQLException{
    	statement = connection.createStatement();
    	String sql = "SELECT COUNT(*) FROM Person WHERE username = '" + username + "'";
    	ResultSet resultSet = statement.executeQuery(sql);
    	resultSet.next();
    	return resultSet.getInt(1) == 0 ? false : true;
    }
    
    public void setAlarm(int eventId, String username, Time time) throws SQLException{
    	statement = connection.createStatement();
    	String sql = "INSERT INTO Alarm (time, eventId, username) VALUES ('" + time + "', " + eventId + ", '" + username + "')";
    	statement.executeUpdate(sql);
    }
    
}

