class Solution {
    int[][] vis;
    int rowCount, colCount;
    Queue<Node> q = new LinkedList<>();

    public void solve(char[][] board) {
        rowCount = board.length;
        colCount = board[0].length;
        vis = new int[rowCount][colCount];

        // first row and last row
        for (int i = 0; i < colCount; i++) {
            if (vis[0][i] == 0 && board[0][i] == 'O') {
                bfs(0, i, board);
            }
            if (vis[rowCount - 1][i] == 0 && board[rowCount - 1][i] == 'O') {
                bfs(rowCount - 1, i, board);
            }
        }

        // first column and last column
        for (int i = 0; i < rowCount; i++) {
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                bfs(i, 0, board);
            }
            if (vis[i][colCount - 1] == 0 && board[i][colCount - 1] == 'O') {
                bfs(i, colCount - 1, board);
            }
        }

        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(int rowIndex, int colIndex, char[][] board) {
        q.add(new Node(rowIndex, colIndex));
        vis[rowIndex][colIndex] = 1;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < dRow.length; i++) {
                int newRow = n.rowIndex + dRow[i];
                int newCol = n.colIndex + dCol[i];

                if (newRow >= 0 && newRow < rowCount && newCol >= 0 && newCol < colCount
                    && vis[newRow][newCol] == 0 && board[newRow][newCol] == 'O') {
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
