package array_Dequeue;

public class BeanClass_PriorityQueue implements Comparable<BeanClass_PriorityQueue> {
  String name;
  int roll;
 
	public BeanClass_PriorityQueue(String name, int roll) {
	super();
	this.name = name;
	this.roll = roll;
}
	
	@Override
	public String toString() {
		return "[name=" + name + ", roll=" + roll + "]";
	}

	@Override
	public int compareTo(BeanClass_PriorityQueue o) {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
