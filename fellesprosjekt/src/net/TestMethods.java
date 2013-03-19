package net;




public class TestMethods {

	public static void main(String [] args) throws Exception {
    	
    	DBConnection db = new DBConnection("Properties.properties");
    	db.connect();
    	DBMethods dbm = new DBMethods();
    	dbm.setConnection(db.getConnection());
    	
    	//dbm.setNotification(35, "henrik", 1);
//    	for (Group g : dbm.getAllGroups()){
//    		System.out.println(g.getName());
//    	}
    	//ArrayList<HaveCalendar> invitable = dbm.getAllInvitable();
    	
    	//dbm.createEvent("hanskhe", new Timestamp(113, 2, 20, 16, 0, 0, 0), new Timestamp(113, 2, 20, 16, 0, 0, 0), "testEvent", "LoloRama", "NY", "", "R1");
    	
    	//dbm.updateEvent(35, new Timestamp(113, 3, 14, 15, 0, 0, 0), new Timestamp(113, 3, 14, 17, 0, 0, 0), "endretAvtale", "i changed u", "kardemomme by", "R1");
    	//Event e = dbm.createEvent("hanskhe", new Timestamp(113,12,2,15,0,0,0), new Timestamp(113,12,2,16,0,0,0), "prosjekt", "jobbe med prosjektet", "", "helle", null, "");    	   
     
	}
}

