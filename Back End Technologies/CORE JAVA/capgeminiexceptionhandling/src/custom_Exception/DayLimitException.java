package custom_Exception;

public class DayLimitException extends RuntimeException{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Limit exceeded....";
	}
	

}
