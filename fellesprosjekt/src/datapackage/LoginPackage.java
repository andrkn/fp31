package datapackage;

public class LoginPackage implements DataPackage{
	
	private String username; 
	private String password; 
	private int packageNumber;
	private int totalPackages;
	
	public LoginPackage(String username, String password, int packageNumber, int totalpackages){
		this.username = username; 
		this.password = password; 
		this.packageNumber = packageNumber;
		this.totalPackages = totalpackages;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public int getPackageNumber() {
		return packageNumber;
	}

	@Override
	public int getTotalPackages() {
		return totalPackages;
	}

}
