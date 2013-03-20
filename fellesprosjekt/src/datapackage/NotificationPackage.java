package datapackage;

public class NotificationPackage implements DataPackage {

	private int packageNumber, totalPackages, eventId, notificationType;
	private String eventName;

	public NotificationPackage(int packageNumber, int totalPackages, int eventId, int notificationType, String evnentName) {
		this.packageNumber = packageNumber;
		this.totalPackages = totalPackages;
		this.eventId = eventId;
		this.notificationType = notificationType;
		this.eventName = eventName;
	}
	
	
	@Override
	public int getPackageNumber() {
		// TODO Auto-generated method stub
		return packageNumber;
	}

	@Override
	public int getTotalPackages() {
		// TODO Auto-generated method stub
		return totalPackages;
	}


	public int getNotificationType() {
		return notificationType;
	}


	public int getEventId() {
		return eventId;
	}


	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	public String getEventName() {
		return this.eventName;
	}

}
