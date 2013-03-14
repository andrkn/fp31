
package datapackage;

import model.HaveCalendar;

public class CalendarRequestPackage implements DataPackage{
	
	private String name;
	private Integer group;
	private Integer packageNumber, totalPackages;
	
	public CalendarRequestPackage(String name, Integer group, Integer packageNumber, Integer totalPackages){
		this.name = name;
		this.group = group;
		this.packageNumber = packageNumber;
		this.totalPackages = totalPackages;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Integer getGroup(){
		return this.group;
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

}

