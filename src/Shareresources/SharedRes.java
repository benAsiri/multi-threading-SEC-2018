

package Shareresources;
import java.util.Collections;

public class SharedRes {
	 public static void main(String[] args) {
		    
	        
	        //Imutable Resource fullName 
	            String fullName="Dileepa";  
	            
	            System.err.println(Integer.toHexString(fullName.hashCode()));
	        //Modifying the fullName vaule
	            fullName.replace("Dileepa", "Rajapaksa");
	            fullName=fullName.concat(" ");
	            
	            
	        //Output the value 
	            System.out.println(fullName);
	            
	            System.err.println(Integer.toHexString(fullName.hashCode()));
	            Integer myage = 26;
	         
	         
	           
	            
	            
	        
	    }
}
