//Solution 2: Two pointer approach
class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int i = 0;
        int j = n - 1;
        while(i != j && i < n && j >= 0) {
            if (mat[i][j] == 1) {
                //i knows j, hence i cannot be celebrity
                i++;
            } else if (mat[j][i] == 1) {
                //j knows i, hence j cannot be celebrity
                j--;
            } else {
                //both i and j cannot be celebrity, as celebrity is definitely known by others
                i++;
                j--;
            }
        }
        if (i >= n || j < 0) {
            return -1; //no celebrity
        }
        
        //check if i is celebrity
        for (j = 0; j < n; j++) {
            if (i == j) {
                continue;
            }
            if (mat[i][j] != 0) {
                return -1; //celebrity is not supposed to know anyone
            }
            if (mat[j][i] != 1) {
                return -1; //everyone should know the celebrity
            }
        }
        return i;
    }
}

//Solution 1: Count know's count and known by count
class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int[] knowsCount = new int[n];
        int[] knownCount = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (mat[i][j] == 1) {
                    knowsCount[i]++;
                    knownCount[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (knowsCount[i] == 0 && knownCount[i] == (n - 1)) {
                return i;
            }
        }
        return -1;
    }
}