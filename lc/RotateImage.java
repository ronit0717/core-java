//Solution 2 : Inplace solution => transpose + reverse row. SC = O(1)
class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    private void reverse(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                //swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - 1 - j];
                matrix[i][m - 1 - j] = temp;
            }
        }
    }

    private void transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                //swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

//Solution 1 (Using a separate matrix)
/*
matrix[j][m - 1 - i] = ansMatrix[i][j]
*/
class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - 1 - i] = matrix[i][j];
            }
        }
        //copy
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }
}