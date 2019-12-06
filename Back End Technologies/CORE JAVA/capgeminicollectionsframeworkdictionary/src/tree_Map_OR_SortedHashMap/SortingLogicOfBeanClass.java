package tree_Map_OR_SortedHashMap;

import java.util.Comparator;

public class SortingLogicOfBeanClass implements Comparator<StudentBean>{

	@Override
	public int compare(StudentBean o1, StudentBean o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}

	
	
	
	
}
