package pvr_booking;

public class Test_Thread1 {
 public static void main(String[] args) {
     System.out.println("Main started..");
	 PVR p=new PVR();
	 Thread1 t1=new Thread1(p);
	 
	 try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 t1.start();
	 p.leaveME();
	
	
	 System.out.println("Main ended....");
	 
}
	
	
	
}
