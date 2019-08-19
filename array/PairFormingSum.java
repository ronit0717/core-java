import java.util.HashSet;
import java.util.Scanner;

public class PairFormingSum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //Size of the array
        int size = sc.nextInt();

        //Array Inputs
        int inp[] = new int[size];
        for(int i=0; i<size; i++){
            inp[i] = sc.nextInt();
        }

        //sum I am looking for
        int sum = sc.nextInt();
        sc.close();

        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0; i<size; i++){
            int complement = sum - inp[i];

            if(hs.contains(inp[i])){
                System.out.println("Yes");
                return;
            }else{
                hs.add(complement);
            }
        }

        System.out.println("No");
    }
}