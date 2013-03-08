package net;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

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
		return sql;
		
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
    
    public static void main(String[] args) throws SQLException {
    	String url = "jdbc:mysql://mysql.stud.ntnu.no/gardmf_Calendar";
    	String user = "gardmf_fellespro";
    	String password = "gruppe31";
    	DBConnection db = new DBConnection(url, user, password);
    	db.connect();
    	
    	connection = db.getConnection();
    	
    	String s = createEvent("gard",new Time(12,0,0), new Time(14,0,0), "meeting", "just a meeting", "jobben", 
				"per paal petter", "14 15 20 45", "H415");
    	
    	System.out.println(s);
	}
}
