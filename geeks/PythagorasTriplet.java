// https://practice.geeksforgeeks.org/problems/pythagorean-triplet/0

import java.util.*;
import java.lang.*;
import java.io.*;
class PythagorasTriplet
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int tc = sc.nextInt();
	    
	    for(int t=0; t<tc; t++){
	        int len = sc.nextInt();
	        
	        HashSet<Double> hs = new HashSet<Double>();
	        int[] inpArray = new int[len];
	        
	        for(int i=0; i<len; i++){
                inpArray[i] = sc.nextInt();
                hs.add(Math.pow((double)inpArray[i], 2));
            }
            boolean found = false;
	        
	        for(int i=0; i<len-1; i++){
                if(found){
                    break;
                }

	            for(int j=i+1; j<len; j++){

                    
                    double sqr = Math.pow((double)inpArray[i], 2) + Math.pow((double)inpArray[j], 2);
                    if(hs.contains(sqr)){
                        System.out.println("Yes");
                        found = true;
                        break;
                    }
	            }
            }

            if(!found){
                System.out.println("No");
            }
            
	    }
	    sc.close();
	 }
}