class Solution {
public int[][] generateMatrix(int n) {
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int[][] ans = new int[n][n];
        int num = 1;
        while (top <= bottom && left <= right) {
            // left to right
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            top++;

            // from top to bottom
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = num++;
            }

            right--;

            // from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = num++;
                }
            }

            bottom--;

            // from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = num++;
                }
            }
            left++;


        }
        return ans;
    }
}