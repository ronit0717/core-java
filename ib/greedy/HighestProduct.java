/*
Given an array A, of N integers A.

Return the highest product possible by multiplying 3 numbers from the array.

NOTE:  Solution will fit in a 32-bit signed integer.



Input Format:

The first and the only argument is an integer array A.

Output Format:

Return the highest possible product.

Constraints:

1 <= N <= 5e5

Example:

Input 1:
A = [1, 2, 3, 4]

Output 1:
24

Explanation 1:
2 * 3 * 4 = 24

Input 2:
A = [0, -1, 3, 100, 70, 50]

Output 2:
350000

Explanation 2:
70 * 50 * 100 = 350000
*/

/*
Algo: Find the min 2 elements (as these two can be two negative integers), 
and 3 max positive interger
Then computer prod 1 = product of the 2 negative integers and the max positive integers
and prod 2 = product of the 3 positive integers

The max of prod 1 and prod 2 will be the answer
*/

public class Solution {
    public int maxp3(ArrayList<Integer> A) {
        Collections.sort(A);
        int nums[] = new int[5]; //first two elements min value, last 3 elements max value
        int size = A.size();
        nums[0] = A.get(0);
        nums[1] = A.get(1);
        nums[2] = A.get(size -3);
        nums[3] = A.get(size -2);
        nums[4] = A.get(size -1);

        int prod1 = nums[0] * nums[1] * nums[4];
        int prod2 = nums[2] * nums[3] * nums[4];

        return Math.max(prod1, prod2);
    }
}
