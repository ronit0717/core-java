//Question Link: https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0

/* 
DEV NOTES:
---------

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class StringPermutation
 {
	static StringBuilder sb;
	static boolean isEmpty = true;

	public static void main (String[] args)
	 {
		Scanner sc = new Scanner(System.in);
	    
	    int tc = sc.nextInt();
	    sc.nextLine();
	    
	    for(int t=0; t<tc; t++){
			isEmpty = true;
	        String inp = sc.nextLine();
            sb = new StringBuilder();

            int swapStartIndex = 0;
			int len = inp.length();

			char[] inpArr = new char[len];
			for(int i=0; i<len; i++){
				inpArr[i] = inp.charAt(i);
			}

			getSwapped(inpArr, swapStartIndex, len);

			String answer = getStringSorted();

	        System.out.println(answer);
	    }
	 }

	 private static String getStringSorted(){
		 StringBuilder sorter = new StringBuilder();
		 
		 String[] myArray = (sb.toString()).split(" ");
		 Arrays.sort(myArray);

		 for(int i=0; i<myArray.length; i++){
			 if(i==0){
				sorter.append(myArray[i]);
			 }else{
				sorter.append(" ");
				sorter.append(myArray[i]);
			 }
		 }

		 return sorter.toString();
	 }
	 

	 //this function will swap the index element with all indexes ahead of it. 
	 //If last index, will add the string in stringBuilder
     private static void getSwapped(char[] inpArr, int index, int len){

		for(int i=index; i<len; i++){
			if(index == len-1){
				String retStr = getStrFromArray(inpArr);
				if(isEmpty){
					sb.append(retStr);
					isEmpty = false;
				}else{
					sb.append(" ");
					sb.append(retStr);
				}
			}else{
				//swap
				//System.out.println("Swapping index:"+index+" with i:"+i);
				char temp = inpArr[i];
				inpArr[i] = inpArr[index];
				inpArr[index] = temp;

				int newIndex = index + 1;
				getSwapped(inpArr, newIndex, len);

				//reverse
				temp = inpArr[i];
				inpArr[i] = inpArr[index];
				inpArr[index] = temp;
			}
		}
	 }
	 
	 private static String getStrFromArray(char[] cArray){
		 StringBuilder sbTemp = new StringBuilder();

		 for(int i=0; i<cArray.length; i++){
			 sbTemp.append(cArray[i]);
		 }

		 return sbTemp.toString();
	 }
}