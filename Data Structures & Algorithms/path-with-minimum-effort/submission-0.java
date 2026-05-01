class Solution {
 int[][] diff;
    int rowSize, colSize;

    int minimumEffortPath(int[][] heights) {
        rowSize = heights.length;
        colSize = heights[0].length;

        diff = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            Arrays.fill(diff[i], Integer.MAX_VALUE);
        }

        return dij(heights);
    }


    private int dij(int[][] heights) {
        PriorityQueue<Cell> pq = new PriorityQueue<>(
                (a, b) -> {
                    return a.diff - b.diff;
                });
        pq.add(new Cell(0, 0, 0));
        diff[0][0] = 0;

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();

            if (curr.rowIndex == rowSize - 1 && curr.colIndex == colSize - 1) return curr.diff;

            int currDiff = curr.diff;

            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};

            for (int i = 0; i < dRow.length; i++) {
                int newRow = curr.rowIndex + dRow[i];
                int newCol = curr.colIndex + dCol[i];

                if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize) { // valid cell exist then only calculating the new diff
                    int newDiff = Math.abs(heights[newRow][newCol] - heights[curr.rowIndex][curr.colIndex]);
                    int actualDiff = Math.max(currDiff, newDiff);
                    if (actualDiff < diff[newRow][newCol]) {
                        diff[newRow][newCol] = actualDiff;
                        pq.add(new Cell(newRow, newCol, actualDiff));
                    }

                }
            }

        }

        return diff[rowSize - 1][colSize - 1];
    }

    class Cell {
        int rowIndex;
        int colIndex;
        int diff;

        Cell(int rowIndex, int colIndex, int diff) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
            this.diff = diff;
        }

    }
}