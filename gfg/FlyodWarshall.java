class Solution {
    public void shortestDistance(int[][] mat) {
        // Code here
        int n = mat.length;
        int large = 100000000;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == -1) {
                    mat[i][j] = large;
                }
            }
        }
        
        for(int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int currDist = mat[i][j];
                    int newDist = mat[i][via] + mat[via][j];
                    mat[i][j] = Math.min(currDist, newDist);
                }
            }
        }
        
        /* Detect Negative Cycle
        for (i = 0; i < n; i++) {
            if (mat[i][j] < 0) {
                //It has negative cycle
            }
        }
        */
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == large) {
                    mat[i][j] = -1;
                }
            }
        }
    }
}