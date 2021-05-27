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