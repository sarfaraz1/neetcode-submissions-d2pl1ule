class Solution {
int[][] vis;
    int rowCount, colCount, count = 0;
    Queue<Node> q = new LinkedList<>();

    public int numEnclaves(int[][] grid) {
        rowCount = grid.length;
        colCount = grid[0].length;
        vis = new int[rowCount][colCount];

        //first row and last row
        for (int i = 0; i < colCount; i++) {
            if (vis[0][i] == 0 && grid[0][i] == 1) {
                bfs(0, i, grid);
            }
            if (vis[rowCount - 1][i] == 0 && grid[rowCount - 1][i] == 1) {
                bfs(rowCount - 1, i, grid);
            }
        }

        //first column and last column
        for (int i = 0; i < rowCount; i++) {
            if (vis[i][0] == 0 && grid[i][0] == 1) {
                bfs(i, 0, grid);
            }
            if (vis[i][colCount - 1] == 0 && grid[i][colCount - 1] == 1) {
                bfs(i, colCount - 1, grid);
            }
        }

        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int rowIndex, int colIndex, int[][] grid) {
        q.add(new Node(rowIndex, colIndex));
        vis[rowIndex][colIndex] = 1;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < dRow.length; i++) {
                int newRow = n.rowIndex + dRow[i];
                int newCol = n.colIndex + dCol[i];

                if (newRow >= 0 && newRow < rowCount && newCol >= 0 && newCol < colCount && vis[newRow][newCol] == 0
                        && grid[newRow][newCol] == 1) {
                    q.add(new Node(newRow, newCol));
                    vis[newRow][newCol] = 1;
                }

            }

        }

    }

    class Node {
        int rowIndex;
        int colIndex;

        Node(int rowIndex, int colIndex) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }
    }
}