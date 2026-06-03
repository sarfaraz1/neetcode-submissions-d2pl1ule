class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        solve(0, nums, new ArrayList<Integer>(), target);

        return ans;
    }

    void solve(int index, int[] input, List<Integer> output, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        if (index == input.length || target < 0) {
            return;
        }
        // pick

        output.add(input[index]);
        solve(index, input, output, target - input[index]);

        output.removeLast();

        // not pick

        solve(index + 1, input, output, target);
    }
}
