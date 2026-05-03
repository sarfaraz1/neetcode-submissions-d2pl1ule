class Solution {
public boolean canPartition(int[] nums) {
        int sum = doSum(nums);

        // not even so we cannot  partition in equal subset sum
        if (sum % 2 != 0) return false;

        // since it is even each partition should have sum divided by 2
        return isSubsetSum(nums, sum / 2);
    }

    private int doSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }


    private boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[][] t = new boolean[n + 1][sum + 1];

        //initialize
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }
        t[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = (t[i-1][j - arr[i - 1]] || (t[i - 1][j]));

                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];

    }
}
