class Solution {
  int[][] vis;
    int ansTime = 0;
    int rowSize, colSize;
    Queue<FruitData> q = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        rowSize = grid.length;
        colSize = grid[0].length;
        vis = new int[rowSize][colSize];

        // initialize vis
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 1;
                    q.add(new FruitData(i, j, 0));
                }
            }
        }

        bfs(grid);

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0)
                    return -1;
            }
        }
        return ansTime;
    }

    private void bfs(int[][] grid) {
        while (!q.isEmpty()) {
            FruitData entry = q.poll();
            int rowIndex = entry.rowIndex;
            int colIndex = entry.colIndex;
            int time = entry.time;
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};

            for (int i = 0; i < dRow.length; i++) {
                int newRow = rowIndex + dRow[i];
                int newCol = colIndex + dCol[i];

                if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize &&
                        vis[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                    ansTime = time + 1;
                    q.add(new FruitData(newRow, newCol, ansTime));
                    vis[newRow][newCol] = 1;
                }

            }


        }
    }

    class FruitData {
        int rowIndex;
        int colIndex;
        int time;

        FruitData(int rowIndex, int colIndex, int time) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
            this.time = time;
        }
    }
}
