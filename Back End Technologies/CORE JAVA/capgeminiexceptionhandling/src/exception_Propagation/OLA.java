package exception_Propagation;

public class OLA {
   GoogleMap g1;

public OLA(GoogleMap g1) {
	super();
	this.g1 = g1;
}
   
 public void location(GoogleMap g1 ){
	 try{
	 g1.findlocation(null);
	 }
	 catch(NullPointerException n){
		 System.out.println("OLA is handling the exception.... ");
	 }
	 
	 
 }
		
}
