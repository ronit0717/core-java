//https://practice.geeksforgeeks.org/problems/anagram/0

import java.util.*;
import java.io.*;
import java.lang.*;

public class Anagram{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        sc.nextLine();

        for(int t=0; t<tc; t++){
            String inp = sc.nextLine();
            String[] inpArray = inp.split(" ");
            String a = inpArray[0];
            String b = inpArray[1];

            System.out.println("a -->"+ a);
            System.out.println("b -->"+ b);
            

            boolean terminate = false;

            if(a.length() != b.length()){
                System.out.println("NO");
                terminate = true;
            }else{
                int len = a.length();
                HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
                for(int i = 0; i< len; i++){
                    char c = a.charAt(i);
                    int count = 0;
                    if(hm.containsKey(c)){
                        count = hm.get(c);
                    }
                    count++;
                    hm.put(c, count);
                }

                for(int i = 0; i< len; i++){
                    char c = b.charAt(i);
                    int count = 0;
                    if(hm.containsKey(c)){
                        count = hm.get(c);
                    }else{
                        System.out.println("NO");
                        terminate = true;
                        break;
                    }
                    count--;
                    if(count == 0){
                        hm.remove(c);
                    }else{
                        hm.put(c, count);
                    }
                    
                }

                if(!terminate){
                    if(hm.isEmpty()){
                        System.out.println("YES");
                    }else{
                        System.out.println("NO");
                    }
                }
            }
        }
        sc.close();
    }
}