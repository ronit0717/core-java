import java.util.Arrays;
import java.util.Scanner;

public class ClosestToNum {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int n1 = sc.nextInt();

        int inp1[] =  new int[n1];
        System.out.println("Enter values of 1st array");
        for(int i=0; i < n1; i++){
            inp1[i] = sc.nextInt();
        }

        System.out.println("Enter size of 2nd array");
        int n2 = sc.nextInt();

        int inp2[] =  new int[n2];
        System.out.println("Enter values of 2nd array");
        for(int i=0; i < n2; i++){
            inp2[i] = sc.nextInt();
        }

        System.out.println("Enter target number");
        int target = sc.nextInt();

        sc.close();

        Arrays.sort(inp1);
        Arrays.sort(inp2);

        int start = n1-1;
        int end = 0;

        int minDiff = Integer.MAX_VALUE;
        String minDiffPair = "";
        while(true){
            int num = inp1[start] + inp2[end];
            int diff = Math.abs(num - target);

            if(diff == 0){
                System.out.println("Pair found : ("+inp1[start] +","+ inp2[end]+")");
                return;
            }else if(diff < minDiff){
                minDiff = diff;
                minDiffPair = "Min Diff Pair : ("+inp1[start] +","+ inp2[end]+")";
            }

            if(num < target){
                if(end == n2-1){
                    break;
                }else{
                    end++;
                }
            }else{
                if(start == 0){
                    break;
                }else{
                    start--;
                }
            }
        }

        System.out.println(minDiffPair);



    }
}