package hashSet;

public class Student_HasSet {
  String name;
  int roll;
	public Student_HasSet(String name, int roll) {
		super();
		this.name = name;
		this.roll = roll;
	}
	
	@Override
		public boolean equals(Object obj) {
		   Student_HasSet sh=(Student_HasSet)obj;
		   if(this.name.equals(sh.name) && this.roll==sh.roll) {
			   return true;
		   }
		   else {
			   return false;
		   }
		}
	
	
	
}
