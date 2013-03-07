package net;

import java.sql.*;

public class DBConnection {

	private Connection connection;;
	private Statement statement;
	
	private String url, user, password;
	
	public DBConnection(String url, String user, String password){
		//skal fikse med properties fil
		this.url = url;
		this.user = user;
		this.password = password;
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
		return this.connection;
	}
	public Statement getStatement(){
		return this.statement;
	}
}