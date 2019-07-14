import java.lang.Math;
import java.util.Scanner;

public class PerfectSquareCheck {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number or enter -1 to exit");

        int num = sc.nextInt();

        while(num != -1){
            double d = Math.sqrt((double)num);
            if(((Math.floor(d) - d) == 0) ){
                System.out.println("Its a perfect Square");
            }else{
                System.out.println("Oops.. not a perfect square");
            }
            System.out.println("Enter a number or enter -1 to exit");
            num = sc.nextInt();
        }
        sc.close();
    }
}