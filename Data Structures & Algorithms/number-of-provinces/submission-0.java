class Solution {
     int[] vis;

    void solve(int[][] adj, int num) {
        vis[num] = 1;
        int[] connectivity = adj[num];

        for (int i = 0; i < connectivity.length; i++) {
            if (vis[i] == 0 && connectivity[i] == 1) {
                solve(adj, i);
            }

        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, count = 0;
        vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                count++;
                solve(isConnected, i);
            }
        }
        return count;
    }
}