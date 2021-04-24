public class Solution {
    public int maxArr(ArrayList<Integer> A) {
        int maxA = Integer.MIN_VALUE;
        int minA = Integer.MAX_VALUE;
        int maxB = Integer.MIN_VALUE;
        int minB = Integer.MAX_VALUE;
        int[] a = new int[A.size()]; //A[i] + i
        int[] b = new int[A.size()]; //A[i] - i
        for (int i = 0; i < A.size(); i++) {
            a[i] = A.get(i) + i;
            b[i] = A.get(i) - i;
            if (a[i] > maxA) {
                maxA = a[i];
            }
            if (a[i] < minA) {
                minA = a[i];
            }
            if (b[i] > maxB) {
                maxB = b[i];
            }
            if (b[i] < minB) {
                minB = b[i];
            }
        }
        return Math.max((maxA - minA), (maxB - minB));
    }
}
