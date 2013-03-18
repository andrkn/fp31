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
    	
    	
    	//System.out.println(dbm.getAlarms());
    	//dbm.setSubGroup(1, 2);
    	
    	//dbm.invitePersons(38, "gardmf");
    	//dbm.answerInvite("gardmf", 38, 1);
    	//dbm.setAlarm(38, "gardmf", new Timestamp(113, 2, 14, 15, 0, 0, 0));
    	//for (Event e : dbm.loadEvents("garmdf")){
    	//	System.out.println(e.getEventId());
    	//}
    	
    	System.out.println(dbm.getIsGoing(36));
    	//Event e = dbm.createEvent("hanskhe", new Timestamp(113,12,2,15,0,0,0), new Timestamp(113,12,2,16,0,0,0), "prosjekt", "jobbe med prosjektet", "", "helle", null, "");
    	db.close();
    	
    	
//    	for(Event e : dbm.loadEvents("hanskhe")){
//    		System.out.println(e.getEventId());
//    	}
    	   
     
	}
}

