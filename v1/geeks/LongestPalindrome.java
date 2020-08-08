//https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string/0

import java.util.*;
import java.lang.*;
import java.io.*;
class LongestPalindrome
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    
	    int tc = sc.nextInt();
	    sc.nextLine();
	    
	    for(int t=0; t<tc; t++){
	        String inp = sc.nextLine();
            String answer  = "";
            int maxLen = 0;

            for(int i=0; i<inp.length(); i++){
                int leftIndex = i;
                int rightIndex = i;

                while(leftIndex >= 0 && rightIndex < inp.length()){
                    if(inp.charAt(leftIndex) == inp.charAt(rightIndex)){
                        String subStr = inp.substring(leftIndex, rightIndex+1);

                        if(subStr.length() > maxLen){
                            answer = subStr;
                            maxLen = subStr.length();
                        }
                    }else{
                        break;
                    }

                    leftIndex--;
                    rightIndex++;
                }
            }

            for(int i=1; i<inp.length(); i++){
                int leftIndex = i-1;
                int rightIndex = i;

                while(leftIndex >= 0 && rightIndex < inp.length()){
                    if(inp.charAt(leftIndex) == inp.charAt(rightIndex)){
                        String subStr = inp.substring(leftIndex, rightIndex+1);

                        if(subStr.length() > maxLen){
                            answer = subStr;
                            maxLen = subStr.length();
                        }
                    }else{
                        break;
                    }

                    leftIndex--;
                    rightIndex++;
                }
            }

            System.out.println(answer);
        }
        
        sc.close();
	 }
}