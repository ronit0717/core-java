/* Solution 2: Using single for loop to check all conditions

Note the box check
offset_row = 3 * (row / 3), offset_col = 3 * (col / 3)

Also:
i       i/3     i%3
--      ---     ---
0       0       0
1       0       1
2       0       2
3       1       0
4       1       1
5       1       2
6       2       0
7       2       1
8       2       2

This gives all 9 elements inside the box grid
This solution simplifies the code, but was slower because of more operations involved
*/
class Solution {
    public void solveSudoku(char[][] board) {
        char[] chars = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        boolean status = sudokuUtil(board, 0, chars);
    }
    
    private boolean sudokuUtil(char[][] board, int index, char[] chars) {
        if (index == 81) {
            return true;
        }
        int currRow = index / 9;
        int currCol = index % 9;
        
        if (board[currRow][currCol] != '.') {
            return sudokuUtil(board, index + 1, chars);
        }
        
        for (int k = 0; k < 9; k++) {
            char c = chars[k];
            if (checkValid(c, currRow, currCol, board)) {
                board[currRow][currCol] = c;
                boolean status = sudokuUtil(board, index + 1, chars);
                if (status) {
                    return status;
                }
                board[currRow][currCol] = '.'; //backtrack
            }
        }
        
        return false;
    }
    
    private boolean checkValid(char c, int currRow, int currCol, char[][] board) {
        for (int i = 0; i < 9; i++) {
            //Vertical Check
            if (board[i][currCol] == c) {
                return false;
            }
            
            //Horizontal Check
            if (board[currRow][i] == c) {
                return false;
            }
            
            //Box Check
            if (board[3 * (currRow / 3) + (i / 3)][3 * (currCol / 3) + (i % 3)] == c) {
                return false;
            }
        }
        return true;
    }
    
}

/* Solution 1: Using 3 for loops to check condition */
class Solution {
    public void solveSudoku(char[][] board) {
        char[] chars = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        boolean status = sudokuUtil(board, 0, chars);
    }
    
    private boolean sudokuUtil(char[][] board, int index, char[] chars) {
        if (index == 81) {
            return true;
        }
        int currRow = index / 9;
        int currCol = index % 9;
        
        if (board[currRow][currCol] != '.') {
            return sudokuUtil(board, index + 1, chars);
        }
        
        for (int k = 0; k < 9; k++) {
            char c = chars[k];
            if (checkVertical(c, currRow, currCol, board) 
                && checkHorizontal(c, currRow, currCol, board) 
                && checkSubBox(c, currRow, currCol, board) 
             ) {
                board[currRow][currCol] = c;
                boolean status = sudokuUtil(board, index + 1, chars);
                if (status) {
                    return status;
                }
                board[currRow][currCol] = '.'; //backtrack
            }
        }
        
        return false;
    }
    
    private boolean checkVertical(char c, int currRow, int currCol, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i][currCol] == c) {
                return false;
            }
        }
        return true;
    }
    
    private boolean checkHorizontal(char c, int currRow, int currCol, char[][] board) {
        for (int j = 0; j < 9; j++) {
            if (board[currRow][j] == c) {
                return false;
            }
        }
        return true;
    }
    
    private boolean checkSubBox(char c, int currRow, int currCol, char[][] board) {
        int iStart = 0, iEnd = 0, jStart = 0, jEnd = 0;
        
        if (currRow > 5) { iStart = 6; iEnd = 8; } 
        else if (currRow > 2) { iStart = 3; iEnd = 5; } 
        else { iStart = 0; iEnd = 2; }
        
        if (currCol > 5) { jStart = 6; jEnd = 8; } 
        else if (currCol > 2) { jStart = 3; jEnd = 5; } 
        else { jStart = 0; jEnd = 2; }
        
        for (int i = iStart; i <= iEnd; i++) {
            for (int j = jStart; j <= jEnd; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}