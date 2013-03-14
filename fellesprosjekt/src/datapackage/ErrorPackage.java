package datapackage;

public class ErrorPackage implements DataPackage{
	
	private String description; 
	private ErrorType errorType;
	private int packageNumber, totalPackages;
	
	public ErrorPackage(ErrorType errorType, String description, int packageNumber, int totalPackages){
		this.errorType = errorType;
		this.description = description; 
		this.packageNumber = packageNumber;
		this.totalPackages = totalPackages;
	}

	public String getDescription(){
		return description; 
	}
	public ErrorType getErrorType(){
		return errorType;
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
