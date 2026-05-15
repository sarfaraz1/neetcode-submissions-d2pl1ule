class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int curr = sum % k;
            if (curr == 0 && i + 1 >= 2)
                return true;
            else if (map.containsKey(curr)) {
                int index = map.get(curr);
                int length = i - index;
                if (length >= 2)
                    return true;

            } else
                map.put(curr, i);
        }
        return false;
    }
}