class Solution {
public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> leftIndex = new Stack<>();
        Stack<Integer> rightIndex = new Stack<>();

        int[] leftSmallest = new int[heights.length];
        int[] rightSmallest = new int[heights.length];

        // left
        for (int i = 0; i < heights.length; i++) {
            while (!leftIndex.isEmpty() && heights[i] <= heights[leftIndex.peek()]) {
                leftIndex.pop();
            }
            leftSmallest[i] = leftIndex.isEmpty() ? -1 : leftIndex.peek();
            leftIndex.push(i);
        }

        // right
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!rightIndex.isEmpty() && heights[i] <= heights[rightIndex.peek()]) {
                rightIndex.pop();
            }
            rightSmallest[i] = rightIndex.isEmpty() ? heights.length : rightIndex.peek();
            rightIndex.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            int width = rightSmallest[i] - leftSmallest[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }
}
