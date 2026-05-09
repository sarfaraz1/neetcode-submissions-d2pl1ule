class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] t = new int[m][n];


        if (obstacleGrid[0][0] == 1) return 0;

        t[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (obstacleGrid[i][j] == 1) {
                    t[i][j] = 0;
                } else {
                    int left = 0, up = 0;
                    if (j > 0) left = t[i][j - 1];
                    if (i > 0) up = t[i - 1][j];

                    t[i][j] = left + up;
                }
            }
        }

        return t[m - 1][n - 1];

    }
}