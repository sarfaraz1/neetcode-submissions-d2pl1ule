class Solution {
     public int longestOnes(int[] nums, int k) {
        int n = nums.length, i = 0, j = 0, maxLen = 0, zeroes = 0;

        while (j < n) {
            if (nums[j] == 0) zeroes++;
            if (zeroes <= k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            if (zeroes > k) {
                if (nums[i] == 0) zeroes--;
                i++;
            }
            j++;
        }
        return maxLen;
    }
}