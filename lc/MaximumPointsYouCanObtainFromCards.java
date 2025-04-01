class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        int maxSum = leftSum;
        int leftPointer = k;
        int rightPointer = cardPoints.length;
        for (int i = 0; i < k; i++) {
            leftPointer--;
            rightPointer--;
            leftSum -= cardPoints[leftPointer];
            rightSum += cardPoints[rightPointer];
            int sum = leftSum + rightSum;
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}