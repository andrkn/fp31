package datapackage;

public class ErrorPackage implements DataPackage{
	
	private String description; 
	private ErrorType errorType;
	
	public ErrorPackage(ErrorType errorType, String description){
		this.errorType = errorType;
		this.description = description; 
	}

	public String getDescription(){
		return description; 
	}
	public ErrorType getErrorType(){
		return errorType;
	}
}
