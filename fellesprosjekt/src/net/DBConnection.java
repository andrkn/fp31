package net;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class DBConnection {

	private Connection connection;;
	private Statement statement;
	
	private String url, jdbcDriver;
	private Properties properties;
	
	public DBConnection(Properties prop) throws IOException{
        properties = prop;
		url = properties.getProperty("url");
		jdbcDriver = properties.getProperty("jdbcDriver");
        statement = null;
        connection = null;
	}
	
	public DBConnection(String propertiesFilename) throws IOException,
	ClassNotFoundException, SQLException {
		properties = new Properties();
		InputStream in = DBMethods.class.getResourceAsStream(propertiesFilename);
		properties.load(in);
		jdbcDriver = properties.getProperty("jdbcDriver");
		url = properties.getProperty("url");
	}
	
	public boolean connect (){
		try{
			Class.forName(jdbcDriver).newInstance();
			connection = DriverManager.getConnection(url, properties.getProperty("user"), properties.getProperty("password"));
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
	public void close() throws SQLException {
		connection.close();
	}
	
}