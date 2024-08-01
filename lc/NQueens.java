/** Solutio 4: Backtracking Optimised (Stores a hash for Queen position) */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        //populate empty board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new LinkedList<>();
        boolean[] rowHash = new boolean[n];
        boolean[] diagHash1 = new boolean[(2*n - 1)];
        boolean[] diagHash2 = new boolean[(2*n - 1)];
        recurr(0, board, ans, n, rowHash, diagHash1, diagHash2);
        return ans;
    }

    private void recurr(int index, char[][] board, 
                        List<List<String>> ans, 
                        int n,
                        boolean[] rowHash,
                        boolean[] diagHash1,
                        boolean[] diagHash2) {
        if (index == n) {
            ans.add(buildAnswer(board, n));
            return;
        }
        for(int i = 0; i < n; i++) {
            int hashIndex1 = i + index; // (row + col)
            int hashIndex2 = (n - 1) + (i - index); // (n - 1) + (row - col)
            if(rowHash[i] || diagHash1[hashIndex1] || diagHash2[hashIndex2]) {
                continue;
            }

            //Put Queen
            board[i][index] = 'Q';
            rowHash[i] = true;
            diagHash1[hashIndex1] = true;
            diagHash2[hashIndex2] = true;

            recurr(index + 1, board, ans, n, rowHash, diagHash1, diagHash2);

            //Remove Queen
            board[i][index] = '.';
            rowHash[i] = false;
            diagHash1[hashIndex1] = false;
            diagHash2[hashIndex2] = false;
        }
    }

    private List<String> buildAnswer(char[][] board, int n) {
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}

/** Solution 3: Backtracking (Not optimised. Uses direction to search the matrix for validity) */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        //populate empty board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new LinkedList<>();
        recurr(0, board, ans, n);
        return ans;
    }

    private void recurr(int index, char[][] board, List<List<String>> ans, int n) {
        if (index == n) {
            ans.add(buildAnswer(board, n));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!canFill(i, index, board, n)) {
                continue;
            }
            board[i][index] = 'Q';
            recurr(index + 1, board, ans, n);
            board[i][index] = '.';
        }
    }

    private boolean canFill(int row, int col, char[][] board, int n) {
        int[][] dirrArr = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < 8; i++) {
            int[] dirr = dirrArr[i];
            int x = row + dirr[0];
            int y = col + dirr[1];
            while(x >= 0 && x < n && y >= 0 && y < n) {
                if (board[x][y] == 'Q') {
                    return false;
                }
                x = x + dirr[0];
                y = y + dirr[1];
            }
        }
        return true;
    }

    private List<String> buildAnswer(char[][] board, int n) {
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}

/* Solution 2: Optimized approach from solution 1
Here instead of using a set used a sequence array. The value of the sequence array represents the String
example if sequence[i] = 2 , this implies string is [..Q.], ie Q is in 2th position

Condition: If deltaX (The horizontal distance between the queens) == deltaY (vertical distance between the queens),
then condition not met

SC = O(N) for visited array + O(N) for sequence array => O(N)
TC = O(N!) for permutation * O(N^2) for the condition check => O(N^2 * N!)
*/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] sequence = new int[n];
        boolean[] visited = new boolean[n];
        List<List<String>> res = new LinkedList<>();
        
        nQueenUtil(res, sequence, visited, 0);
        return res;
    }
    
    private void nQueenUtil(List<List<String>> res, int[] seq, boolean[] visited, int index) {
        if (index == seq.length) {
            res.add(getSolutionSet(seq));
            return;
        }
        for (int i = 0; i < seq.length; i++) {
            if (visited[i] || !checkValidSeq(seq, i, index)) {
                continue;
            }
            visited[i] = true;
            seq[index] = i;
            
            nQueenUtil(res, seq, visited, index+1);
            
            visited[i] = false; //reset
        }
        
    }
    
    private boolean checkValidSeq(int[] seq, int i, int index) {
        for (int j = 0; j < index; j++) {
            int deltaWidth = Math.abs(seq[j] - i);
            int deltaHeight = Math.abs(j - index);
            if (deltaWidth == deltaHeight) {
                return false;
            }
        }
        return true;
    }
    
    private List<String> getSolutionSet(int[] seq) {
        List<String> set = new LinkedList<>();
        int n = seq.length;
        for (int i = 0; i < n; i++) {
            set.add(getRow(n, seq[i]));
        }
        return set;
    }
    
    private String getRow(int n, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == index) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}

/*
Solution 1: Kind of brute
Created a set, for example n = 4 => set = [ [Q...], [.Q..], [..Q.], [...Q] ]
Then found permutations of the set provided the condition is met

Condition: If deltaX (The horizontal distance between the queens) == deltaY (vertical distance between the queens),
then condition not met
*/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<String> set = getSet(n);
        boolean[] visited = new boolean[n];
        List<List<String>> res = new LinkedList<>();
        checkAndPermuteUtil(set, new LinkedList<>(), visited, res);
        return res;
    }
    
    private void checkAndPermuteUtil(List<String> set, List<String> cand, boolean[] visited, List<List<String>> res) {
        int n = set.size();
        if (cand.size() == n) {
            res.add(new LinkedList<>(cand));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (conditionCheck(cand, i)) {
                cand.add(set.get(i));
                visited[i] = true;
                checkAndPermuteUtil(set, cand, visited, res);
                
                //reset
                visited[i] = false;
                cand.remove(cand.size() - 1); //remove last cand
            }
        }
    }
    
    private boolean conditionCheck(List<String> cand, int i) {
        for (int j = 0; j < cand.size(); j++) {
            int qPos = getQPosition(cand.get(j));
            int deltaWidth = Math.abs(qPos - i);
            int deltaHeight = Math.abs(j - cand.size());
            if (deltaWidth == deltaHeight) {
                return false;
            }
        }   
        return true;
    }
    
    private int getQPosition(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Q') {
                return i;
            }
        }
        return -1;
    }
    
    private List<String> getSet(int n) {
        List<String> set = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            set.add(getArrangedString(i, n));
        }
        return set;
    }
    
    private String getArrangedString(int index, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == index) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}