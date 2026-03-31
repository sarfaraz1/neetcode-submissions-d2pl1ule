class Solution {
   List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> output = new ArrayList<>();
        solve(nums, 0, output);

        return ans;
    }

    private void solve(int[] nums, int index, List<Integer> output) {
        if (nums.length == index) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // not pick
        solve(nums, index + 1, new ArrayList<>(output));

        // pick
        List<Integer> newList = new ArrayList<>(output);
        newList.add(nums[index]);
        solve(nums, index + 1, newList);
    }
}