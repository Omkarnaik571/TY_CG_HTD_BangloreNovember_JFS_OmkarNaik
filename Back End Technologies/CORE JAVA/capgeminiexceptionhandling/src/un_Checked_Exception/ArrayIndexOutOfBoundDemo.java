package un_Checked_Exception;

public class ArrayIndexOutOfBoundDemo {
  public static void main(String[] args) {
	int []arr=new int[2];
	  arr[0]=12;
	  arr[1]=24;
	  try{
	  arr[2]=34;
	  }
	  catch(RuntimeException r){
	  }
	  finally{
		  System.out.println("......definitely run........");
	  }
	  
}
	
	
	
}
