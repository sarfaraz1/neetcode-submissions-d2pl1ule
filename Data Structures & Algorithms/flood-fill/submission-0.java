class Solution {
   int initialColor, rowSize, colSize;
    int[][] vis;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        initialColor = image[sr][sc];

        // if initial and the new color are same then we don't need to do anything
        if (initialColor == color) return image;
        
        rowSize = image.length;
        colSize = image[0].length;
        vis = new int[rowSize][colSize];

        dfs(image, sr, sc, color);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color) {
        image[sr][sc] = color;
        vis[sr][sc] = 1;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        for (int i = 0; i < dRow.length; i++) {
            int newRow = sr + dRow[i];
            int newCol = sc + dCol[i];

            if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize
                    && image[newRow][newCol] == initialColor && vis[newRow][newCol] == 0) {
                dfs(image, newRow, newCol, color);
            }

        }
    }
}