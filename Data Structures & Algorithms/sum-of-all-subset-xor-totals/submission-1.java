class Solution {
   public int subsetXORSum(int[] nums) {
        int sum = 0;

        return solve(0, nums, 0);

    }

    int solve(int index, int[] input, int xor) {
        if (index == input.length) {
            return xor;
        }

        return solve(index + 1, input, xor ^ input[index]) + solve(index + 1, input, xor);
    }
}