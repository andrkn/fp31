package net;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.HashMap;
import java.util.Properties;

public class DBMethods {
	
	private static Connection connection = null;
	private static Statement statement = null;
	
	public void setConnection(Connection con){
		connection = con;
	}
	
	public void setStatement(Statement statm){
		statement = statm;
	}
	
	public static String createEvent(String createdBy, Time startTime, Time endTime, String eventName, 
			String description, String place, String invitedPersons, String invitedGroups, String roomNr) throws SQLException{
		
		statement = connection.createStatement();
		String sql = "INSERT INTO Event (createdBy_username, startTime, endTime, eventName, " +
				"description, place, invitedPersons, invitedGroups, roomNr) VALUES ('"+ createdBy 
				+ "', '" + startTime + "', '" + endTime + "', '" + eventName + "', '" + description + "', '" +
						place + "', '" + invitedPersons + "', '" + invitedGroups + "', '" + roomNr + "')";
		statement.executeUpdate(sql);
		if (!invitedPersons.equals("")){
			String sql2 = "SELECT * FROM Event WHERE createdBy_username = '" + createdBy + "' AND startTime = '" + startTime + "'";
			ResultSet rs = statement.executeQuery(sql2);	
			rs.beforeFirst();
			rs.next();
			int eventId = rs.getInt(1);
			for (String person : invitedPersons.split(" ")){
				updateInvited(person, eventId);
			}
			
		}
		return sql;
	}
	
	public static void updateInvited(String username, int eventId) throws SQLException{
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
    
    public byte[] getStoredHash(String username, String collumnName) throws Exception{
    	String sql = "SELECT * FROM Person WHERE username = '" + username +"'";
    	ResultSet resultSet = statement.executeQuery(sql);
    	resultSet.next();
    	byte[] hash = resultSet.getBytes(collumnName);
    	return hash;
    }
    
    public static void main(String[] args) throws SQLException, IOException {
    	Properties prop = new Properties();
        InputStream in = DBMethods.class.getResourceAsStream("Properties.properties");
        prop.load(in);
    	DBConnection db = new DBConnection(prop);
    	db.connect();
    	
    	connection = db.getConnection();
    	String s = createEvent("gard", new Time(8,0,0), new Time(10,0,0), "møte", "husk notater", "kontoret", "henrik andre", "", ""); 
    	System.out.println(s);
	}
}
