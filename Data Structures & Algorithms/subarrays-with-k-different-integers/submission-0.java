class Solution {
   public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }

    int solve(int[] nums, int k) {
        int n = nums.length, i = 0, j = 0, count = 0;
        Map<Integer, Integer> intToFreqMap = new HashMap<>();
        while (j < n) {
            intToFreqMap.put(nums[j], intToFreqMap.getOrDefault(nums[j], 0) + 1);

            while (intToFreqMap.size() > k) {
                intToFreqMap.put(nums[i], intToFreqMap.get(nums[i]) - 1);
                if (intToFreqMap.get(nums[i]) == 0)
                    intToFreqMap.remove(nums[i]);
                i++;
            }


            count += j - i + 1;

            j++;
        }
        return count;
    }
}