class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int prefix = 1;
        ans[0] = 1;
        // storing prefix
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];

        }

        int suffix = 1;

        for (int i = n - 2; i >= 0; i--) {
            suffix = nums[i + 1] * suffix;
            ans[i] *= suffix;
        }
        return ans;
    }
}  
