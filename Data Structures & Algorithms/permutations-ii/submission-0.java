class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        solve(0, nums);

        return ans;
    }

    void solve(int index, int[] input) {
        List<Integer> temp = new ArrayList<>();
        if (index == input.length) {
            for (int num : input) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        Set<Integer> used = new HashSet<>();
        for (int i = index; i < input.length; i++) {
            if (!used.contains(input[i])) {
                used.add(input[i]);
                swap(index, i, input);
                solve(index + 1, input);
                swap(index, i, input);
            }
        }
    }

    void swap(int index, int i, int[] input){
        int temp = input[index];
        input[index] = input[i];
        input[i] = temp;
    }
}