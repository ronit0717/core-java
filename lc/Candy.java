//Solution 3: Slope Approach. TC = O(N), SC = O(1)
class Solution {
    public int candy(int[] ratings) {
        int sum = 1;
        int curr = 0;
        int n = ratings.length;
        int prev;
        int i = 1;
        while (i < n) {
            //flat
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            //up slope
            prev = 1;
            boolean up = false;
            while (i < n && ratings[i] > ratings[i - 1]) {
                up = true;
                curr = prev + 1;
                sum += curr;
                prev = curr;
                i++;
            }
            int peak = curr;

            //down slope
            prev = up ? 0 : prev;
            boolean down = false;
            while(i < n && ratings[i] < ratings[i - 1]) {
                down = true;
                curr = prev + 1;
                sum += curr;
                prev = curr;
                i++;
            }

            int bottom = curr + 1;
            if (up && down && bottom > peak) {
                sum += bottom - peak;
            }
        }
        
        return sum;
    }
}

//Solution 2: TC = O(2N), SC=O(N)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) {
            return 1;
        }

        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int sum = 0;
        sum += Math.max(left[n - 1], 1);
        int prev = 1;
        for (int i = n - 2; i >= 0; i--) {
            int curr = 1;
            if (ratings[i] > ratings[i + 1]) {
                curr += prev;
            }
            sum += Math.max(left[i], curr);
            prev = curr;
        }
        return sum;
    }
}

//Solution 1: TC = O(2N), SC=O(2N)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            int j = n - 1 - i;
            //update left
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
            //update right
            if (ratings[j] > ratings[j + 1]) {
                right[j] = right[j + 1] + 1;
            } else {
                right[j] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}