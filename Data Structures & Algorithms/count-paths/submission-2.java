class Solution {

 public int uniquePaths(int m, int n) {
        int[][] t = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = 1;

            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int left = t[i][j - 1];
                int up = t[i - 1][j];

                t[i][j] = left + up;
            }
        }

        return t[m - 1][n - 1];
    }

}
