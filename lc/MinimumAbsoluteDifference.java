class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff <= min) {
                List<Integer> setList = new LinkedList<>();
                setList.add(arr[i - 1]);
                setList.add(arr[i]);
                if (diff < min) {
                    min = diff;
                    res = new LinkedList<>();
                }
                res.add(setList);
            }
        }
        return res;
    }
}

/* To determine max of function | A[i] - A[j] | - | i - j |

        A= [1,  3,  -1]
        i= [1,  2,   3]
A[i]+i   = [2,  5,   4]  diffMax = 3 (i = 2, j = 1)
A[i]-i   = [0,  1,  -4]  diffMax = 5 (i = 1, j = 2) ans=5



Explanation:
In above example, there can be total 9 combinations of i and j

    i   <   j       i   >   j       i   =   j
    ==========     ===========      =========
    1       2       2       1       1       1
    1       3       3       1       2       2
    2       3       3       2       3       3

For i = j, the function always returns 0, ignoring this case

There are 4 total ways the function gets defined based on the values of A[i], A[j], i  and j. But there are distinct two cases
(A[i] - i) - (A[j] - j)  => A[i] > A[j] and i > j  (Equation 1)
this is same as A[i] < A[j] and i < j, because i and j values get interchanged

(A[i] + i) - (A[j] + j)  => A[i] > A[j] and i < j  (Equation 2)
this is same as A[i] < A[j] and i > j, because i and j values get interchanged

For max value in each equation, the first part of the equation needs to be maximum and second part needs to be min

For equation 1
arr of A[i]+i   => [2,  5,   4]  diffMax = 3 (when i = 2, j = 1)

For equation 2
arr of A[i]-i   => [0,  1,  -4]  diffMax = 5 (when i = 1, j = 2)

overall for our function, thus maximum abs difference = 5 (when i = 1, j = 2)
*/