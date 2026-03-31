class Solution {
   public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pSum = new int[n];

        pSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pSum[i] = pSum[i - 1] + nums[i];
        }

        int leftIndex, rightIndex, leftSum, rightSum;
        for (int i = 0; i < n; i++) {
            leftIndex = i - 1;
            if (leftIndex == -1)
                leftSum = 0;
            else
                leftSum = pSum[leftIndex];

            rightSum = pSum[n - 1] - pSum[i];

            if (leftSum == rightSum)
                return i;
        }

        return -1;
    }
}