class Solution {
    int[][] t;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        t = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(t[i], -1);
        }


        return solve(m - 1, n - 1, obstacleGrid);
    }

    public int solve(int i, int j, int[][] obstacleGrid) {
        if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;

        if (i < 0 || j < 0) return 0;

        if (t[i][j] != -1) return t[i][j];
        int left = solve(i, j - 1, obstacleGrid);
        int up = solve(i - 1, j, obstacleGrid);

        return t[i][j] = left + up;

    }
}