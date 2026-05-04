class Solution {
   public int findTargetSumWays(int[] nums, int target) {
        int sum = doSum(nums);

        if ((sum + target) % 2 != 0) return 0;

        int subSetValue = (sum + target) / 2;

        return perfectSum(nums, subSetValue);
    }

    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] t = new int[n + 1][target + 1];

        //initialize
        for (int i = 0; i <= target; i++) {
            t[0][i] = 0;
        }

        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                // handle the zero case
                if (nums[i - 1] == 0) {
                    t[i][j] = 2 * t[i - 1][j];
                } else if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }

        }

        return t[n][target];
    }

    private int doSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
