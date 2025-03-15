class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            if (i == 0 || i == board.length - 1) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(i, j, board, visited);
                }
            } else {
                dfs(i, 0, board, visited);
                dfs(i, board[0].length - 1, board, visited);
            } 
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
            || board[i][j] == 'X' || visited[i][j]
        ) {
            return;
        }
        visited[i][j] = true;
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int newI = i + dirX[k];
            int newJ = j + dirY[k];
            dfs(newI, newJ, board, visited);
        }
    }
}