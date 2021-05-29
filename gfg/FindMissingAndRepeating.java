//https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/


//Solution 1 : Using HashSet and sum of first n natural numbers formula
//Time complexity : O(n), space complexity : O(n)
class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();
        long sum = ((long)n*((long)n+1))/2;
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                res[0] = arr[i];
                continue;
            }
            sum -= arr[i];
            set.add(arr[i]);
        }
        res[1] = (int)sum;
        return res;
    }
}

//Solution 2: Using sum of first n natural numbers and sum of squares of first n natural numbers formula
//Time complexity : O(n), space complexity = O(1)
class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        
        long sum = 0L;
        long sumSquare = 0L;
        
        long size = (long)n;
        long actualSum = (size * (size + 1L)) / 2L;
        long actualSumSquare = (size * (size + 1L) * (2L * size + 1L)) / 6L;
        
        for (int i = 0; i < n ; i++) {
            long num = (long)arr[i];
            sum += num;
            sumSquare += (num * num);
        }
        
        long yxDiff = actualSum - sum; //y missing, x repeating
        long yxSum = (actualSumSquare - sumSquare) / (yxDiff);
        
        long x = (yxSum - yxDiff) / 2L;
        long y = (yxSum + yxDiff) / 2L;
        
        int[] res = new int[2];
        res[0] = (int)x;
        res[1] = (int)y;
        return res;
    }
}

/*
Explantion/Rough work:

1, 2, 4, 2 => sum = 9

a_sum = 10 = n(n+1)/2

sum -x + y = a_sum      here x : repeating, y : missing

eg:
9 - 2 + 3 = 10



Square
1, 2, 4, 2 => 1+ 4+ 16+ 4 => sum_sq = 25 

a_sum_sq = (n(n+1)(2n + 1))/6 = (4*5*9)/6 = 30

sum_sq - x^2 + y^2 = a_sum_sq

25 - 4 + 9 = 30




y^2 - x^2 = a_sum_sq - sum_sq;
y - x = a_sum - sum = yxDiff

y + x = (a_sum_sq - sum_sq) / (a_sum - sum) = yxSum



y = (yxDiff + yxSum)/ 2;
x = (yxSum - yxDiff)/2;


*/



//Solution 3 : XOR Solution
import java.util.ArrayList;

public class HelloWorld{

     public static void main(String []args){
        
        int arr[] = { 9, 10, 8, 6, 1, 3, 2, 5, 6, 4}; //6 is repeating and 7 is missing
        int n = 10;
        
        //step 1
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ arr[i];
        }
        
        //step 2
        for (int i = 1; i <= n; i++) {
            xor = xor ^ i;
        }
        
        //xor = missing number ^ repeating number
        int num = new Integer(xor);
        int sigIndex = 1; //right most significant digit in binary representation
        while (num != 1) {
            num /= 2;
            sigIndex++;
        }
        
        ArrayList<Integer> bucket1 = new ArrayList<>();
        ArrayList<Integer> bucket2 = new ArrayList<>();
        
        //step 3 : filling the buckets with numbers in the input array
        for (int i = 0; i < n; i++) {
            bucketInsert(arr[i], sigIndex, bucket1, bucket2);
        }
        
        //step 4: filling the buckets with numbers from range [1..n]
        for (int i = 1; i <= n; i++) {
            bucketInsert(i, sigIndex, bucket1, bucket2);
        }
        
        //step 5
        int num1 = 0;
        for (int i = 0; i < bucket1.size(); i++) {
            num1 = num1 ^ bucket1.get(i);
        }
        
        int num2 = 0;
        for (int i = 0; i < bucket2.size(); i++) {
            num2 = num2 ^ bucket2.get(i);
        }
        
        //step 6
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num1) {
                res[0] = num1; //repeating number
                res[1] = num2; //missing number
                break;
            } else if (arr[i] == num2) {
                res[0] = num2; //repeating number
                res[1] = num1; //missing number
            }
        }
        
        print(res);
        
     }
     
     private static void print(int[] res) {
         for (int i : res) {
             System.out.print(i + " ");
         }
     }
     
     private static void bucketInsert(int i, int sigIndex, ArrayList<Integer> bucket1, ArrayList<Integer> bucket2) {
        int num = new Integer(i);
        int count = 1;
        boolean added = false;
        
        while (num != 1) {
            
            int rem = num % 2;
            num /= 2;
            if (count == sigIndex && rem == 1) {
                bucket1.add(i);
                added = true;
            } else if (count == sigIndex && rem == 0) {
                bucket2.add(i);
                added = true;
            }
            
            count++;
            if (count > sigIndex) {
                break;
            }
        }
        
        if (!added) {
            if (count == sigIndex) {
                bucket1.add(i);
            } else {
                bucket2.add(i);   
            }
        }
    }
}
/* Algo

Step 1. Do a xor or all the elements in the array
Step 2. With the result in step 1, do a xor of all elements from [1..n] => The result, resXor = MisingNumber^RepeatingNumber
(The resXor right most bit will be 1, this means one of the missing number's and repeating number's bit at that index will be 1 and the other will be 0)
Step 3. Separate elements of the array in two buckets, one which has that bit at that index as 0, and other which has bit at that index as 1
Step 4. To the same bucket, now for all elements from [1..n], sort them in the two buckets with the same condition
Step 5. Do xor in each bucket, we will find the two numbers
Step 6. If we iterate the array again we will get confirmed which one of these two numbers is the missing number and which one is the repeating number

*/