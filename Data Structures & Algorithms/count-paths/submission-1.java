class Solution {
    int[][] t;

    public int uniquePaths(int m, int n) {
        t = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(t[i], -1);
        }


        return solve(m - 1, n - 1);
    }

    public int solve(int i, int j) {
        if (i == 0 && j == 0) return 1;

        if (i < 0 || j < 0) return 0;

        if (t[i][j] != -1) return t[i][j];
        int left = solve(i, j - 1);
        int up = solve(i - 1, j);

        return t[i][j] = left + up;

    }
}
