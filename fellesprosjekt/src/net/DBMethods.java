package net;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

public class DBMethods {
	
	private Connection connection = null;
	private Statement statement = null;
	
	public void setConnection(Connection connection){
		this.connection = connection;
	}
	
	public void setStatement(Statement statement){
		this.statement = statement;
	}
	
	public void createEvent(String createdBy, Time startTime, Time endTime, String eventName, 
			String description, String place, String invitedPersons, String invitedGroups, String roomNr){
		
		String sql = "INSERT INTO Event (createdBy_username, startTime, endTime) VALUES ('"+ createdBy 
				+ "', '" + startTime + "', '" + endTime + "')";
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
    
    public byte[] getStoredHash(String username, String collumnName) throws Exception{
    	String sql = "SELECT * FROM Person WHERE username = '" + username +"'";
    	ResultSet resultSet = statement.executeQuery(sql);
    	resultSet.next();
    	byte[] hash = resultSet.getBytes(collumnName);
    	return hash;
    }
}
