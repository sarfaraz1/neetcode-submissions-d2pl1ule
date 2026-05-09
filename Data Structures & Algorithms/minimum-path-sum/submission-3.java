class Solution {
    int[][] t;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        t = new int[m][n];

        for (int[] arr : t) {
            Arrays.fill(arr, -1);
        }

        solve(m - 1, n - 1, grid);
        return t[m - 1][n - 1];
    }

    private int solve(int i, int j, int[][] grid) {
        if (i < 0 || j < 0) return 100000;

        if (i == 0 && j == 0) return t[i][j] = grid[0][0];

        if (t[i][j] != -1) return t[i][j];
        int left = grid[i][j] + solve(i, j - 1, grid);
        int up = grid[i][j] + solve(i - 1, j, grid);

        return t[i][j] = Math.min(left, up);
    }
}