class Solution {
   public int[] singleNumber(int[] nums) {
        int n = nums.length;
        long xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
        }

        long rightMostSetBit = (xor & xor - 1) ^ xor;
        int b1 = 0, b2 = 0;

        for (int i = 0; i < n; i++) {
            if ((rightMostSetBit & nums[i]) != 0) {
                b1 = b1 ^ nums[i];
            } else {
                b2 = b2 ^ nums[i];
            }
        }
        int[] ans = new int[2];
        ans[0] = b1;
        ans[1] = b2;
        return ans;
    }
}