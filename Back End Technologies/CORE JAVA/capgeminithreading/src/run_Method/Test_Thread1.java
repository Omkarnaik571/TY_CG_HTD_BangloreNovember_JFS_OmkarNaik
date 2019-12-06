package run_Method;

public class Test_Thread1 {
 public static void main(String[] args) {
	Thread1 t1=new Thread1();
	System.out.println("Main started");
	t1.setPriority(1);
	t1.start();
	 System.out.println("main ended..");
	 
	 
	 Runnable1 r1=new Runnable1();
	 Thread tt=new Thread(r1);
	 tt.start();
	 
	 
}
	
	
	
}
