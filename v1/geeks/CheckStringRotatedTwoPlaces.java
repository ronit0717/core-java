//https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places/0

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
			//boolean done = false;
	        String a = sc.nextLine();
			String b = sc.nextLine();
			
			if(a.length() != b.length()){
				System.out.println(0);
			}

			if(clockwiseTwoRotate(a,b) || antiClockwiseTwoRotate(a,b)){
				System.out.println(1);
			}else{
				System.out.println(0);
			}
		}
		
		sc.close();
	 }

	 private static boolean clockwiseTwoRotate(String a, String b){
		 StringBuilder sb = new StringBuilder(a.substring(2));
		 sb.append(a.charAt(0));
		 sb.append(a.charAt(1));

		 //System.out.println("Clockwise :"+sb.toString());

		 if(b.equals(sb.toString())){
			 return true;
		 }

		 return false;
	}

	 private static boolean antiClockwiseTwoRotate(String a, String b){

		StringBuilder sb = new StringBuilder(a.substring(0, a.length()-2));

		sb.insert(0, a.charAt(a.length() -1));
		sb.insert(0, a.charAt(a.length() -2));

		//System.out.println("Anti-Clockwise :"+sb.toString());

		if(b.equals(sb.toString())){
			return true;
		}

		return false;
	 }
}