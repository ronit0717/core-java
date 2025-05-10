//Solution 2: Diagonal search TC = O(M + N)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (j >= 0 && i < m) {
            if(matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--; //move left;
            } else {
                i++; //move down
            }
        }
        return false;
    }
}

//Solution 1: Binary search in each row TC = O(M*LogN), SC=O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            boolean status = searchInRow(matrix[i], target);
            if (status) {
                return status;
            }
        }
        return false;
    }

    private boolean searchInRow(int[] row, int target) {
        int min = 0;
        int max = row.length - 1;
        while(min <= max) {
            int mid = (min + max) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return false;
    }
}