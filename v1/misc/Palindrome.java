import java.util.Scanner;

public class Palindrome {
    public static void main(String args[]){
        System.out.println("Enter Input");
        Scanner sc = new Scanner(System.in);

        String inp = sc.nextLine();
        int len = inp.length();
        int pointer1, pointer2;


        if(len%2 == 0){
            //even length
            pointer1 = len/2 - 1;
            pointer2 = len/2;
        }else{
            //odd length
            pointer1 = (len-1)/2 - 1;
            pointer2 = (len-1)/2 + 1;
        }

        sc.close();

        while(pointer1 >= 0){
            if(inp.charAt(pointer1) != inp.charAt(pointer2)){
                System.out.println("Not Palindrome");
                return;
            }
            pointer1--;
            pointer2++;
        }

        System.out.println("Its a palindrome");


    }
}