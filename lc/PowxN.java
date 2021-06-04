//Solution 1: Recursive Memoization Approach
/* Algo
2 ^ 5 = 2 ^ 3 * 2 ^ 2
2 ^ 3 = 2 ^ 2 * 2 ^ 1
We can thus break recursively
*/

class Solution {
    public double myPow(double x, int n) {
        
        if (n == 0) {
            return 1.0;
        }
        
        if (x == 0.0 || x == 1.0) {
            return x;
        } else if (x == -1.0) {
            if (n % 2 == 0) {
                return -1 * x;
            } else {
                return x;
            }
        }
        
        /*
        Integer.MIN_VALUE = -2147483648
        Integer.MAX_VALUE = 2147483647

        So if I try to max min_value into positive, that will overflow. 
        Hence this case is handledexplicitly
        */
        if (n == Integer.MIN_VALUE) {
            return 0.0; 
        }
        
        if (n == 1) {
            return x;
        }
        
        if (n < 0) {
            n = n * -1;
            x = 1 / x;
        }
        
        HashMap<Integer, Double> mem = new HashMap<>();
        
        double res = myPowUtil(x, n, mem);
        
        return res;
        
    }
    
    private double myPowUtil(double x, int n, HashMap<Integer, Double> mem) {
        if (n == 1) {
            return x;
        }
        if (mem.containsKey(n)) {
            return mem.get(n);
        }
        
        int p1;
        int p2;
        if (n % 2 == 0) {
            p2 = n / 2;
            p1 = p2;
        } else {
            p2 = n / 2;
            p1 = p2 + 1;
        }
        double res = myPowUtil(x, p1, mem) * myPowUtil(x, p2, mem);
        mem.put(n, res);
        return res;
        
    }
}