package clonnableMethod;

public class Clone1Test  {

	public static void main(String[] args) {
		
		Clone1 c1=new Clone1("Rahul", 32);
		System.out.println(c1.name+" "+c1.rollno);
		try{	
		Clone1 c2=(Clone1)c1.clone();
		System.out.println(c2.name+" "+c2.rollno);
		}
		catch(CloneNotSupportedException e){
			e.printStackTrace();
			
		}
		
		
		
		
	}
	
	
	
}
