package throws_keyword;

public class Paytm {
	IRCTC p1;

	public Paytm(IRCTC p1) {
		super();
		this.p1 = p1;
	}
	
	public void bookTicket(){
		try{
		p1.connfirm();
		}
		catch(ClassNotFoundException e){
			System.out.println("Class Not found handled in Paytm....");
		}
	}
	
	
	

}
