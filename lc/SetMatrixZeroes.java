//Solution 3: Space O(1). Enhancement of solution 2 where instead of keeping a separate row and col to store the data, the first row and column is used
/*
1. Traverse each cell, and if it is zero, in the corresponding element in first row and column make it zero
Make a note of if the zero is in the first row or first column itself
2. Now again traverse each cell each first row and first column except first row and column, 
corresponding to first row and first column assign zero to the cell
3. If the first row itself contains the zero, assign all elements in first row as zero
4. If the first column itself contains the zero, assign all elements in first col as zero
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowContainsZero = false;
        boolean firstColContainsZero = false;

        //step 1
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    
                    if (i == 0) {
                        firstRowContainsZero = true;
                    }
                    if (j == 0) {
                        firstColContainsZero = true;
                    }
                }
            }
        }   

        //step 2
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //step 3
        if (firstRowContainsZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        //step 4
        if (firstColContainsZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

//Solution 2: Keeping a separate row and col to store zeroes

//Solution 1.1: Brute force
/*
1. Make an array representing row and column
2. Traverse each cell in matrix, and if cell is 0, make corresponding element in the array as 0
3. Again traverse the matrix, and based on the array make the cells as 0

Time complexity = O(m*n)
Space complexity = O(m+n)
*/

//Solution 1.2: Brute force => Convert row and col to -1, and then at the end convert -1 to 0. No extra space used
//Solution considering matrix does not have a -1
class Solution {
    public void setZeroes(int[][] matrix) {
        //set row and col as -1
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                if (matrix[i][j] == 0) {
                    updateRow(i, matrix);
                    updateColumn(j, matrix);
                }
            }
        }
        //convert -1 to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void updateRow(int row, int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = matrix[row][j] == 0 ? 0 : -1;
        }
    }

    private void updateColumn(int col, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = matrix[i][col] == 0 ? 0 : -1;
        }
    }
}