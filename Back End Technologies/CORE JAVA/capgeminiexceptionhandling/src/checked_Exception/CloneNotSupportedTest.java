package checked_Exception;

public class CloneNotSupportedTest implements Cloneable{
	String namr="aaryan";
	

@Override
public Object clone() throws CloneNotSupportedException {
	// TODO Auto-generated method stub
	System.out.println("Clone is running...."+namr);
	return super.clone();
}
	
	
}
