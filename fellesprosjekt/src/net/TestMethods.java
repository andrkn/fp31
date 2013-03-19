package net;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Date;
import java.util.Set;

import model.Event;


public class TestMethods {

    @SuppressWarnings("deprecation")
	public static void main(String [] args) throws Exception {
    	
    	DBConnection db = new DBConnection("Properties.properties");
    	db.connect();
    	DBMethods dbm = new DBMethods();
    	dbm.setConnection(db.getConnection());
    	
    	
    	ArrayList<String> l1 = new ArrayList<String>();
    	l1.add("arne");
    	l1.add("bjarne");
    	l1.add("carne");
    	l1.add("darne");
    	ArrayList<String> l2 = new ArrayList<String>();
    	l2.add("carne");
    	l2.add("arne");


    	for (String s: l2){
    		if(l1.contains(s)){
    			l1.remove(s);
    		}
    	}
    	for (String s : l1){
    		System.out.println(s);
    	}
    	
    	//dbm.updateEvent(35, new Timestamp(113, 3, 14, 15, 0, 0, 0), new Timestamp(113, 3, 14, 17, 0, 0, 0), "endretAvtale", "i changed u", "kardemomme by", "R1");
    	//Event e = dbm.createEvent("hanskhe", new Timestamp(113,12,2,15,0,0,0), new Timestamp(113,12,2,16,0,0,0), "prosjekt", "jobbe med prosjektet", "", "helle", null, "");    	   
     
	}
}

