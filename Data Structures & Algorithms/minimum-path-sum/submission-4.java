class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] t = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
                if (i == 0 && j == 0)
                    t[i][j] = grid[0][0];

                else {
                    if (j > 0) left = grid[i][j] + t[i][j - 1];
                    if (i > 0) up = grid[i][j] + t[i - 1][j];
                    t[i][j] = Math.min(left, up);
                }
            }
        }
        return t[m - 1][n - 1];
    }
}