class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = buildMatrix(n, edges);

        //Floyd Warshall Algorithm
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int currDist = mat[i][j];
                    int newDist = mat[i][via] + mat[via][j];
                    mat[i][j] = Math.min(currDist, newDist);
                }
            }
        }
        int targetCity = -1;
        int cityCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= cityCount) {
                targetCity = i;
                cityCount = count;
            }
        }
        return targetCity;
    }

    private int[][] buildMatrix(int n, int[][] edges) {
        int large = 100000000;
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    mat[i][j] = 0;
                } else {
                    mat[i][j] = large;
                }
            }
        }
        for (int i = 0; i < edges.length; i++) {
            int city1 = edges[i][0];
            int city2 = edges[i][1];
            int dist = edges[i][2];
            mat[city1][city2] = dist;
            mat[city2][city1] = dist;
        }
        return mat;
    }
}