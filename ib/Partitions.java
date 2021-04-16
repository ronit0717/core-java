public class Solution {
    public int solve(int A, ArrayList<Integer> B) {
        int sum = 0;
        int[] sumArray = new int[A];
        for (int i = 0; i < A; i++) {
            sum += B.get(i);
            sumArray[i] = sum;
        }
        if (sum % 3 != 0) {
            return 0;
        }
        int count1 = 0;
        int fraction1 = sum / 3;
        int fraction2 = sum - fraction1;
        if (sum == 0) {
            int count0 = 0;
            for (int i = 0; i < A; i++) {
                if (sumArray[i] == 0) {
                    count0++;
                }
            }
            return (((count0 - 1) * (count0 - 2)) / 2);
        }
        int count = 0;
        for (int i = 0; i < A; i++) {
            if (sumArray[i] == fraction1) {
                count1++;
            } else if (sumArray[i] == fraction2) {
                count += count1;
            }
        }
        return count;
    }
}
