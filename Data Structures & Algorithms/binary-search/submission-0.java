

class Solution {
   public int search(int[] nums, int target) {

        return binarySearch(nums, 0, nums.length - 1, target);

    }

    int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (target == nums[mid]) return mid;

        else if (target < nums[mid]) {
            return binarySearch(nums, low, mid - 1, target);
        }

        return binarySearch(nums, mid + 1, high, target);

    }
}
