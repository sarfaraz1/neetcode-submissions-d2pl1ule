class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxCount = 0;

        int n = nums.length;

            for (int i = 0, j = 0; j < n; j++) {
            if (i < n && nums[i] == 1 && nums[i] == nums[j]) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
                i = j;
                while (i < n && nums[i] == 0) i++;
            }
        }

        return maxCount;
    }
}