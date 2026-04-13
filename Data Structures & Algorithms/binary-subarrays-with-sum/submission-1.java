class Solution {
     public int numSubarraysWithSum(int[] nums, int goal) {

        return lessThanEqualGoal(nums, goal) - lessThanEqualGoal(nums, goal - 1);
    }

    int lessThanEqualGoal(int[] nums, int goal) {
        if (goal < 0) return 0;

        int n = nums.length, i = 0, j = 0, sum = 0, count = 0;

        while (j < n) {

            sum += nums[j];
            while (sum > goal) {
                sum -= nums[i];
                i++;
            }
            if (sum <= goal) {
                count += j - i + 1;
            }


            j++;
        }
        return count;

    }
}