package net;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Properties;

public class TestMethods {

    public static void main(String [] args) throws SQLException, IOException {
    	Properties prop = new Properties();
        InputStream in = DBMethods.class.getResourceAsStream("Properties.properties");
        prop.load(in);
    	DBConnection db = new DBConnection(prop);
    	db.connect();
    	DBMethods dbm = new DBMethods();
    	dbm.setConnection(db.getConnection());
    	
    	dbm.createEvent("per", new Time(8,0,0), new Time(10,0,0), "møte", "husk notater", "kontoret", "", "1 2", ""); 
	}
}
