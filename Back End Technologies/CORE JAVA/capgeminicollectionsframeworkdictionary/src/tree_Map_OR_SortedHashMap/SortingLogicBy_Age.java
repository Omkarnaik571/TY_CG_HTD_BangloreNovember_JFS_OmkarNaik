package tree_Map_OR_SortedHashMap;

import java.util.Comparator;

public class SortingLogicBy_Age implements Comparator<StudentBean>{

	@Override
	public int compare(StudentBean o1, StudentBean o2) {
		if(o1.age>o2.age) {
			return 1;
		}
		else if(o1.age<o2.age) {
			return -1;
		}
		else {
			return 0;
		}
		
		
	}

	
	
	
	
}
