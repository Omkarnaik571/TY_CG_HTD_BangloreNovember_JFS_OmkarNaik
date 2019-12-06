package un_Checked_Exception;

public class TrywithMultipleCatch {

	void display(String name,int number){
		try{
			System.out.println(name.length());
			 try{
		     System.out.println(10/number);
			 }
			 catch(ArithmeticException e){
					System.out.println("Arithmetic Exception");
				}
		}
        catch(NullPointerException e){
			System.out.println("Null pointer Exception");
		}
		finally{
			 System.out.println("In finally....");
		}
		
	}
	
	public static void main(String[] args) {
		TrywithMultipleCatch ty=new TrywithMultipleCatch();
		ty.display("Hii", 0);
		ty.display(null, 2);	
	}
	
	
	
	
}
