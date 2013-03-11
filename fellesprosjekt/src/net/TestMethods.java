package net;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Properties;

import encryption.PasswordEncryption;

import model.Event;

public class TestMethods {

    public static void main(String [] args) throws Exception {
    	Properties prop = new Properties();
        InputStream in = DBMethods.class.getResourceAsStream("Properties.properties");
        prop.load(in);
    	DBConnection db = new DBConnection(prop);
    	db.connect();
    	DBMethods dbm = new DBMethods();
    	dbm.setConnection(db.getConnection());
    	
    	
    	dbm.setAlarm(22, "hanskhe", new Time(12,0,0));
    	    
    	//dbm.createEvent("per", new Time(8,0,0), new Time(10,0,0), "møte", "husk notater", "kontoret", "", "2", ""); 
	}
}
