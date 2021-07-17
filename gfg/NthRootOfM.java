/*
Use binary search.. the root definitely lies between 1..m

Example: n = 2, m = 16
So root lies in [1 .. 16] => mid = 9 (taking ceil) .. but 9^2 > 16
So root lies in [1 .. 9] => mid = 5 .. but 5^2 > 16
So root lied in [1 .. 5] => mid = 3 .. but 3^2 < 16
So root lied in [3 .. 5] => mid = 4 and 4^2 == 16, hence answer is 4
*/

class Solution
{
    public int NthRoot(int n, int m)
    {
        // code here
        int start = 1;
        int end = m;
        
        if (m == 1 || n == 1) {
            return m;
        }
        
        while (end >= start) {
            double mid = Math.ceil((start + end) / 2.0);
            double check = Math.pow(mid, n);
            if (check > m) {
                end = (int)mid - 1;
            } else if (check < m) {
                start = (int)mid + 1;
            } else {
                return (int)mid;
            }
        }
        return -1;
    }
}