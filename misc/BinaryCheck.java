import java.util.Scanner;

//Code to check if the input is binary

public class BinaryCheck{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter input:");
        int inp = sc.nextInt();

        int rem = inp%10;
        int quo = inp/10;

        if(!(rem==1 || rem==0) ){
            System.out.println("Not binary");
            return;
        }

        while(quo != 0){
            rem = quo%10;
            quo = quo/10;
            
            if(!(rem==1 || rem==0) ){
                System.out.println("Not binary");
                return;
            }
        }

        System.out.println("Its binary");

        sc.close();
    }
}