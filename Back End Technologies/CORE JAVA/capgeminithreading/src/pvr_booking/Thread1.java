package pvr_booking;

public class Thread1 extends Thread{
   PVR p;

public Thread1(PVR p) {
	super();
	this.p = p;
}
   
   public void run() {
	   p.confirmTicket();
}
	
	
	
	
}
