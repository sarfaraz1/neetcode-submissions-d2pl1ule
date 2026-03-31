class Solution {
public boolean searchMatrix(int[][] matrix, int target) {

        boolean result = false;
        for (int i = 0; i < matrix.length; i++) {
            result = result || binarySearch(matrix[i], 0, matrix[i].length - 1, target);

        }
        return result;
    }

    boolean binarySearch(int[] nums, int low, int high, int target) {
        if (low > high)
            return false;

        int mid = (low + high) / 2;
        if (target == nums[mid]) return true;

        else if (target < nums[mid]) {
            return binarySearch(nums, low, mid - 1, target);
        }

        return binarySearch(nums, mid + 1, high, target);

    }
}
