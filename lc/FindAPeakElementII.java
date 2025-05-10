class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int left = 0;
        int right = n - 1;
        int ans;
        while(left <= right) {
            int mid = (left + right) / 2;
            int maxRowIndex = findMaxRowIndex(mat, mid);
            int check = checkPeak(mat, maxRowIndex, mid);
            if (check == 0) {
                return new int[]{maxRowIndex, mid};
            } else if (check == -1) {
                right = mid - 1; //peak will be in left half
            } else {
                left = mid + 1; //peak will be in right half
            }
        }
        return null; //never executed
    }

    private int checkPeak(int[][] mat, int i, int j) {
        int left = (j == 0) ? -1 : mat[i][j - 1];
        int right = (j == mat[0].length - 1) ?  -1 : mat[i][j + 1];
        if (mat[i][j] > left && mat[i][j] > right) {
            return 0;
        } else if (left > mat[i][j]) {
            return -1;
        } else {
            return 1;
        }
    }

    private int findMaxRowIndex(int[][] mat, int col) {
        int maxRowIndex = 0;
        int max = -1;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > max) {
                maxRowIndex = i;
                max = mat[i][col];
            }
        }
        return maxRowIndex;
    }
}