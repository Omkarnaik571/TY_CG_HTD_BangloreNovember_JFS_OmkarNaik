package input_abd_outputStream;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Input_Output_Stream {
   public static void main(String[] args) {
	try {
		FileOutputStream f1=new FileOutputStream("omkar.txt");
		String s="Hello Mr. Naik";
		byte[] b=s.getBytes();        
		f1.write(b);
		
		
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   
	   
}
	
	
	
	
	
}
