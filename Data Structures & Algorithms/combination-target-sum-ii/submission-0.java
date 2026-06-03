class Solution {
List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(0, candidates, new ArrayList<Integer>(), target);
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
        solve(index + 1, input, output, target - input[index]);

        output.removeLast();

        // not pick
        int next = index + 1;
        while (next <= input.length - 1 && input[index] == input[next])
            next++;

        solve(next, input, output, target);
    }
}
