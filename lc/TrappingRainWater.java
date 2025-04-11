/* Solution 2: TC = O(N), SC = O(1)
Algo:
1. Initialize leftMax = 0, left = 0, rightMax = 0, right = last index ie (length - 1), sum = 0
2. while (left <= right)
    1.  if (height[left] <= height[right])
            1. if height[left] > leftMax => update leftMax
            2. else sum += leftMax - height[left]
    2.  else
            1. if height[right] > rightMax => update rightMax
            2. else sum += rightMax - height[right]
3. return sum

Intuition: 
At every point we need either the leftMax or the rightMax. (we need the min of leftMax and rightMax)
Condition in line 2.1 is satisfied only when there is a guarantee that there is a 
pillar in right with height greater than current height, hence water will be stored for sure

similarily, condition 2.2 is satisified only when there is a guarantee that there is a 
pillar in left with height greater than current height, hence water will be stored for sure
*/
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while(left != right) {
            if (height[left] <= height[right]) {
                if (height[left] < leftMax) {
                    water += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (rightMax > height[right]) {
                    water += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return water;
    }
}

/* Solution 1 (Brute Force): TC = O(N), SC = O(N)
Example:
height[] =      0   1   0   2   1   0   1   3   2   1   2   1
leftMaxArr[] =  0   0   1   1   2   2   2   2   3   3   3   3
rightMaxArr[]=  3   3   3   3   3   3   3   2   2   2   1   0
waterStored  =  0   0   1   0   1   2   1   0   0   1   0   0

Calculation => water stored at a point 
minHeight = (min of rightMaxArr and leftMaxArr)
minHeight should be greater than current height, then water stored = minHeight - currentHeight

*/
class Solution {
    public int trap(int[] height) {
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];
        
        int leftMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftMaxArr[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }
        
        int rightMax = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMaxArr[i] = rightMax;
            rightMax = Math.max(rightMax, height[i]);
        }
        
        int waterSum = 0;
        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(leftMaxArr[i], rightMaxArr[i]);
            waterSum += (minHeight > height[i]) ? (minHeight - height[i]) : 0;
        }
        
        return waterSum;
    }
}