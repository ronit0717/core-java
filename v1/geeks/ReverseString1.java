//https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0

import java.util.*;
import java.lang.*;
import java.io.*;
class ReverseString
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    
	    int tc = sc.nextInt();
	    sc.nextLine();
	    
	    for(int t=0; t<tc; t++){
	        String inpt = sc.nextLine();
            //System.out.println(inpt);
            
	        String[] inpArray = inpt.split("\\.");
	        int len = inpArray.length;
	        
	        //System.out.println(len);
	        
	        StringBuilder sb = new StringBuilder("");
	        for(int i= len-1; i>=0; i--){
	            if(i==0){
	                sb.append(inpArray[i]);
	            }else{
                    sb.append(inpArray[i]);
                    sb.append(".");
	            }
	        }
	        System.out.println(sb);
        }
        
        sc.close();
	 }
}