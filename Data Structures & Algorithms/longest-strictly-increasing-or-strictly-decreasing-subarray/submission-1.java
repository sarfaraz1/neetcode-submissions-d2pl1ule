class Solution {
public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int increasingCount = 1, decreasingCount = 1, result = 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                increasingCount++;
                decreasingCount = 1;
                result = Math.max(increasingCount, result);
            } else if (nums[i] > nums[i + 1]) {
                increasingCount = 1;
                decreasingCount++;
                result = Math.max(result, decreasingCount);
            } else {
                increasingCount = 1;
                decreasingCount = 1;
            }
        }


        return result;
    }
}