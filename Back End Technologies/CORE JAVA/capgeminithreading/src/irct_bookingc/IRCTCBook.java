package irct_bookingc;

public class IRCTCBook  extends Thread{
IRCTC i;

public IRCTCBook(IRCTC i) {
	super();
	this.i = i;
}
	

	@Override
		public void run() {
			i.bookTicket();
		}
	
	
	
}
