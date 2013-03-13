package net;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Properties;

import model.Event;


public class TestMethods {

    @SuppressWarnings("deprecation")
	public static void main(String [] args) throws Exception {
    	
    	DBConnection db = new DBConnection("Properties.properties");
    	db.connect();
    	DBMethods dbm = new DBMethods();
    	dbm.setConnection(db.getConnection());
    	
    	//dbm.invitePersons(38, "gardmf");
    	//dbm.answerInvite("gardmf", 38, 1);
    	dbm.setAlarm(38, "gardmf", new Timestamp(113, 2, 14, 15, 0, 0, 0));
    	//for (Event e : dbm.loadEvents("garmdf")){
    	//	System.out.println(e.getEventId());
    	//}
    	
    	//dbm.createEvent("garmdf", new Timestamp(113,11,3,15,0,0,0), new Timestamp(113,11,3,17,0,0,0), "prosjekt", "jobbe med prosjektet", "", "helle hanskhe", "1", "");

    	
    	
//    	for(Event e : dbm.loadEvents("hanskhe")){
//    		System.out.println(e.getEventId());
//    	}
    	   
     
	}
}
