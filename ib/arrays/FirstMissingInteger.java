public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int N = A.size();
        for (int i = 0; i < N; i++) {
            if (A.get(i) >= 1 && A.get(i) <= N && (A.get(i) != i+1)) {
                int curr = A.get(i);
                if (A.get(i) == A.get(curr - 1)) {
                    continue;
                }
                A.set(i, A.get(curr - 1));
                A.set(curr - 1, curr);
                i--;
            }
        }
        for (int i = 0; i < N; i++) {
            if (A.get(i) != (i+1)) {
                return (i+1);
            }
        }
        return N+1;
    }
}

/*

Explanation:

i
|
v
3 2 6 1 -2
|___|
swap

i
|
V
6 2 3 1 -2
(out of range)

  i
  |
  V
6 2 3 1 -2
(self swap)
    
    i
    |
    v
6 2 3 1 -2
(self swap)
 
      i
      |
      V
6 2 3 1 -2
|_____|
  swap

      i
      |
      V
1 2 3 6 -2
(out of range)

         i 
         |
         V
1 2 3 6 -2
(out of range)


Answer is 4

*/