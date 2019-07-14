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
			

			/*
			if(!done){
				if(a.equals(b)){
					System.out.println(1);
					done = true;
				}else{
					for(int i=0; i < a.length(); i++){
						for(int j=0; j < b.length(); j++){
							if(subReverse(a, b, i, j)){
								System.out.println(1);
								done = true;
								break;
							}
						}

						if(done){
							break;
						}
					}
				}
			}
			
			
			if(!done){
				System.out.println(0);
			}

			*/
			
			
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




	 /*
	 
	 private static boolean subReverse(String a, String b, int i, int j){
		System.out.println("\n----------");
		System.out.println("Iteration: i: "+i+" j: "+j);
		StringBuilder sb = new StringBuilder(a.substring(i));
		sb.reverse();

		String stage1 = a.substring(0, i) + sb.toString();
		System.out.println("Stage 1: "+stage1);

		sb = new StringBuilder(stage1.substring(j));
		sb.reverse();

		String stage2 = stage1.substring(0, j) + sb.toString();
		System.out.println("Stage 2: "+stage2);


		if(stage2.equals(b)){
			return true;
		}
		
		return false;
	 }
	 
	 */
}