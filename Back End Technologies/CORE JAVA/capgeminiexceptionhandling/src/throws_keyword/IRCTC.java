package throws_keyword;

public class IRCTC {

	
	public void connfirm() throws ClassNotFoundException{
		try{
		Class.forName("IRCTC");
		System.out.println("Ticket is confirmed...");	
		}
		catch(ClassNotFoundException e){
			System.out.println("Ticket cannot be confirmed");
			throw e;
		}
	}
	
	
}
