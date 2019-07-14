//https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0

import java.util.*;
import java.lang.*;
import java.io.*;
class RemoveAdjacentDuplicate
 {
    private static StringBuilder sb;
    private static String inp;
    
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    
	    int tc = sc.nextInt();
	    sc.nextLine();
	    
	    for(int t=0; t<tc; t++){
	        inp = sc.nextLine();
            
            while(!adjacentRepeatCheck(inp)){
                sb = new StringBuilder();
                cleanPrint(0, 1);
                inp = sb.toString();
            }
            /*
            sb = new StringBuilder();
	        

            //cleanPrint(0,1);   
            
            System.out.println(sb);
            */
            System.out.println(inp);
        }
        
        sc.close();
     }
     
     private static boolean adjacentRepeatCheck(String inp){
        for(int i=1; i<inp.length(); i++){
            if(inp.charAt(i) == inp.charAt(i-1)){
                return false;
            }
        }

        return true;
     }
     
     /* This method doesn't work for all cases */
	 private static void cleanPrint(int point1, int point2){

         int newPoint1;
         int newPoint2;
         if((point2 - point1) == 1){
             if(point2 == inp.length()){
                sb.append(inp.charAt(point1));
                return;
             }

            if(inp.charAt(point1) != inp.charAt(point2)){
                sb.append(inp.charAt(point1));
                newPoint1 = point1 + 1;
                newPoint2 = point2 + 1;
                cleanPrint(newPoint1, newPoint2);
            }else{
                newPoint1 = point1;
                newPoint2 = point2 + 1;
                cleanPrint(newPoint1, newPoint2);
            }
         }else{
            if(point2 == inp.length()){
                return;
             }
            if(inp.charAt(point1) != inp.charAt(point2)){
                newPoint1 = point2;
                newPoint2 = point2 + 1;
                cleanPrint(newPoint1, newPoint2);
            }else{
                newPoint1 = point1;
                newPoint2 = point2 + 1;
                cleanPrint(newPoint1, newPoint2);
            }
         }

         return;
	     
	 }
}