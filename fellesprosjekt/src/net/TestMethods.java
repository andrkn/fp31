package net;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
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
    	
    	//Date date = Date.valueOf("2013-03-13");
    	dbm.deleteEvent(31);
    	//dbm.createEvent("garmdf", new Time(10,0,0), new Time(16,0,0), new Date(2013, 3, 12), "prosjekt", "jobbe med prosjektet", "", "helle hanskhe", "1", "");
    	//Date date = Date.valueOf("2013-03-14");
    	//dbm.createEvent("andre", new Time(12,0,0), new Time(14,0,0), date, "lol", "putekrig", "til helle", "hanskhe", "", "");
    	
//    	for(Event e : dbm.loadEvents("hanskhe")){
//    		System.out.println(e.getEventId());
//    	}
    	
    	//Date date = Date.valueOf("2013-03-12");
    	//dbm.createEvent("hanskhe", new Time(14,0,0), new Time(17,0,0), date, "lunsjdate", "zomg", "downtown", "", "2", "");
    	//dbm.setAlarm(23, "hanskhe", new Time(12,0,0));
    	   
    	//dbm.createEvent("per", new Time(8,0,0), new Time(10,0,0), "møte", "husk notater", "kontoret", "", "2", ""); 
	}
}
