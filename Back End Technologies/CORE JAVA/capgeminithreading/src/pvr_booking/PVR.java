package pvr_booking;

public class PVR {
   
   synchronized	public void confirmTicket() {
//		Thread1 ttt=new Thread1(p);
		
	for (int i = 0; i < 4; i++) {
		System.out.println(i);
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
	
  
  synchronized public void leaveME() {
		System.out.println("Calling notify().....");
		notify();
	}
   
	
	
}
