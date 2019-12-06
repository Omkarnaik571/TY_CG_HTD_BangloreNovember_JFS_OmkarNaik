package irct_bookingc;

public class Test_IRCTCBOOk {
  public static void main(String[] args) {
	System.out.println("Main started..");
	  IRCTC ir=new IRCTC();
	  IRCTCBook ibook=new IRCTCBook(ir);
	  IRCTCBook ibook1=new IRCTCBook(ir);  
	  ibook.start();
	  ibook1.start();  
	  System.out.println("Main ended..");
}
	
	
	
	
}
