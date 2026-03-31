class Solution {
  public boolean isMonotonic(int[] nums) {
        boolean increasing = isIncreasing(nums);
        boolean decreasing = iDecreasing(nums);

        if (increasing || decreasing)
            return true;

        return false;

    }

    private static boolean isIncreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (!(nums[i] <= nums[i + 1]))
                return false;

        }

        return true;
    }

    private static boolean iDecreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (!(nums[i] >= nums[i + 1]))
                return false;

        }

        return true;
    }
}