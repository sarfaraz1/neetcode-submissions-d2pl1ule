class Solution {
     public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            Integer retrievedIndex = numMap.get(remaining);
            if (retrievedIndex != null && i!=retrievedIndex) {
                return new int[]{i, retrievedIndex};
            }

        }
        return new int[]{1, 1};
    }
}
