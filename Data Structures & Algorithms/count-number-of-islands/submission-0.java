class Solution {
     int[][] vis;

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        vis = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    bfs(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }


    private void bfs(int row, int col, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Cell> q = new LinkedList<>();
        vis[row][col] = 1;
        q.add(new Cell(row, col));
        while (!q.isEmpty()) {
            Cell c = q.poll();
            int rowFromQ = c.row;
            int colFromQ = c.col;

            int[] delRowArr = {-1, 0, 1, 0};
            int[] delColArr = {0, 1, 0, -1};

            for (int i = 0; i < delRowArr.length; i++) {


                int newRow = rowFromQ + delRowArr[i];
                int newCol = colFromQ + delColArr[i];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] ==
                        '1' && vis[newRow][newCol] == 0) {
                    vis[newRow][newCol] = 1;
                    q.add(new Cell(newRow, newCol));
                }


            }

        }

    }


    class Cell {
        int row;
        int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
