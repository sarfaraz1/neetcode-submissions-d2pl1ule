class Solution {
 List<List<Integer>> ans = new ArrayList<>();

    public int subsetXORSum(int[] nums) {
        int sum = 0;

        solve(0, nums, new ArrayList<Integer>());

        for (int i = 0; i < ans.size(); i++) {
            int temp = 0;
            for (int num : ans.get(i)) {
                temp ^= num;
            }
            sum += temp;
        }

        return sum;
    }

    void solve(int index, int[] input, List<Integer> output) {
        if (index == input.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // take
        output.add(input[index]);
        solve(index + 1, input, output);

        output.removeLast();


        solve(index + 1, input, output);
    }
}