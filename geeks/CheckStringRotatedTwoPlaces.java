import java.util.*;
import java.lang.*;
import java.io.*;
class CheckStringReversedTwoPlaces
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int tc = sc.nextInt();
	    sc.nextLine();
	    
	    for(int t=0; t<tc; t++){
	        String a = sc.nextLine();
	        String b = sc.nextLine();
	        
	        if(a.equals(b)){
	            System.out.println(1);
	            return;
	        }
	    }
	 }
	 
	 private static String subReverse(String inStr, int i, int j){
         
     }
}