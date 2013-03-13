package model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import net.DBConnection;
import net.DBMethods;

public class TestInviteModel {

	
	public static void main(String args[]) throws SQLException, IOException {
		Properties prop = new Properties();
        InputStream in = DBMethods.class.getResourceAsStream("Properties.properties");
        prop.load(in);
    	DBConnection db = new DBConnection(prop);
    	db.connect();
    	DBMethods dbm = new DBMethods();
    	dbm.setConnection(db.getConnection());
		InviteListModel model = new InviteListModel(26);
		Person p = new Person();
		p.setName("Henrik");
		Group g = new Group();
		g.setName("Gruppe1");
		ArrayList<Person> members = new ArrayList<Person>();
		members.add(p);
		g.setMembers(members);
		model.addInvite(p);
		model.addInvite(g);
		
		model.sendInvite(model.getEventId(), model.getInviteList(), dbm);
	}
}
