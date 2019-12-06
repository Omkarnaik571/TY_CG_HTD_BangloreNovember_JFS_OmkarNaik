package irct_bookingc;

public class IRCTC {

synchronized public void bookTicket() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
//				wait(1000);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
}
