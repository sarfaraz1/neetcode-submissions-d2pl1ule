class Solution {
   List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        solve(0, nums);
        return ans;
    }

    void solve(int index, int[] nums) {
        List<Integer> temp = new ArrayList<>();
        if (index == nums.length) {
            for (int num : nums) {
                temp.add(num);
            }
            ans.add(temp);
        }


        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            solve(index + 1, nums);
            swap(nums, index, i);

        }

    }

    void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
}
