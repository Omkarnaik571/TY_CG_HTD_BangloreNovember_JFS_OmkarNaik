package exception_Propagation;

public class GoogleMap {

	void findlocation(String location){
		try{
		System.out.println(location.length());
		}
		catch(NullPointerException n){
			System.out.println("Google map handling the exception...");
			throw n;
		}
		
	}
	
	
	
}
