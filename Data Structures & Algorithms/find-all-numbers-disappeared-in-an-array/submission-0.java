class Solution {
   public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length, i = 0;
        while (i < n) {
            if (nums[i] - 1 != i && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i);
            } else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (nums[j] - 1 != j) {
                ans.add(j + 1);
            }
        }
        return ans;
    }

    void swap(int[] nums, int i) {
        int temp = nums[i];
        nums[i] = nums[temp - 1];
        nums[temp - 1] = temp;
    }
}