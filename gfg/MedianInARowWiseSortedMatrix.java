//Problem link: https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1

class Solution {
    int median(int mat[][]) {
        // code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, mat[i][0]);
            max = Math.max(max, mat[i][n - 1]);
        }
        
        int total = m * n;
        int targetCount = (total / 2) + 1; //there should be targetCount nums <= median
        int ans = -1;
        
        while (min <= max) {
            int mid = (min + max) / 2;
            int count = getCountLessThanOrEqualTo(mat, mid);
            if (count >= targetCount) {
                ans = mid;
                max = mid - 1; //in search of a better ans
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }
    
    int getCountLessThanOrEqualTo(int[][] mat, int target) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            int rowCount = 0;
            int min = 0;
            int max = mat[i].length - 1;
            
            while(min <= max) {
                int mid = (min + max) / 2;
                if (mat[i][mid] <= target) {
                    rowCount = mid + 1;
                    min = mid + 1; //in search of a greater num
                } else {
                    max = mid - 1;
                }
            }
            count += rowCount;
        }
        return count;
    }
    
}