class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[] = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j] = matrix[i][j] == '0' ? 0 : (dp[j] + 1);
            }
            int area = maxAreaHistogram(dp);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    /* Stack and Queue Series L12 (Leetcode: 84) */
    private int maxAreaHistogram(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if(st.isEmpty() || heights[i] > heights[st.peek()]) {
                st.push(i);
                continue;
            }
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                int index = st.pop();
                int rb = i;
                int lb = st.isEmpty() ? 0 : st.peek() + 1;
                int area = heights[index] * (rb - lb);
                maxArea = Math.max(area, maxArea);
            }
            st.push(i);
        }
        
        while(!st.isEmpty()) {
            int index = st.pop();
            int rb = heights.length; //these elements dont have a right smaller element
            int lb = st.isEmpty() ? 0 : st.peek() + 1;
            int area = heights[index] * (rb - lb);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}