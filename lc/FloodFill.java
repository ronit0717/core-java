class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int colorCondition = image[sr][sc];
        util(image, sr, sc, colorCondition, color);
        return image;
    }

    private void util(int[][] image, int i, int j, int colorCondition, int newColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length 
                || image[i][j] != colorCondition || image[i][j] == newColor) {
            return;
        }
        image[i][j] = newColor;
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int newI = i + dirX[k];
            int newJ = j + dirY[k];
            util(image, newI, newJ, colorCondition, newColor);
        }
    }
}