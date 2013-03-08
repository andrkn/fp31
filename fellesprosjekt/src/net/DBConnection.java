package net;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class DBConnection {

	private Connection connection;;
	private Statement statement;
	
	private String url, user, password;
	
	public DBConnection(Properties prop) throws IOException{
        url = (String) prop.get("url");
        user = (String)prop.get("user");
        password = (String)prop.get("password"); 
        statement = null;
        connection = null;
	}
	
	public boolean connect (){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			if(connection != null){
				return true;
			}
		} catch (Exception e) {
			System.out.println("Connection failed: " + e.getMessage());
		}
		return false; 
	}
	
	public Connection getConnection(){
		return connection;
	}
	public Statement getStatement(){
		return statement;
	}
	
}