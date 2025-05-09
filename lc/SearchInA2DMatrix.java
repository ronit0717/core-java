//TC = O(LogM) + O(LogN) = O(LogMN)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int n = matrix[0].length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][n - 1]) {
                return findInRow(matrix[mid], target);
            } else if (target > matrix[mid][n - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    private boolean findInRow(int[] row, int target) {
        int low = 0;
        int high = row.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}

//Solution 2: Virtually convert the 2D array to 1D Array. TC = O(LogMN)
// -> Consider low = 0, high = (m * n) - 1. The index should be used to derive the row and column