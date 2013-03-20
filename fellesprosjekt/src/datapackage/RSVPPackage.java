package datapackage;

public class RSVPPackage implements DataPackage {

	private int packageNumber, totalPackages, eventId;
	private Boolean rsvp;
	private String username;
	
	public RSVPPackage(int packageNumber, int totalPackages, int eventId, Boolean rsvp, String username) {
		this.packageNumber = packageNumber;
		this.totalPackages = totalPackages;
		this.eventId = eventId;
		this.rsvp = rsvp;
		this.username = username;
	}
	
	@Override
	public int getPackageNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalPackages() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getEventId() {
		return eventId;
	}


	public Boolean getRsvp() {
		return rsvp;
	}
	
	public String getUsername() {
		return this.username;
	}

}
