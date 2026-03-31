class Solution {
   List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> output = new ArrayList<>();
        solve(nums, 0, output);

        List<List<Integer>> uniqueList = new ArrayList<>();

        Map<List<Integer>, Boolean> subsetToBooleanMap = new HashMap<>();

        for (List<Integer> subset : ans) {
            Collections.sort(subset);
            if (!subsetToBooleanMap.containsKey(subset)) {
                subsetToBooleanMap.put(subset, true);
                uniqueList.add(subset);
            }
        }


        return uniqueList;
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
