class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        solve(nums, 0, new ArrayList<>());

        Set<List<Integer>> uniqueSet = new HashSet<>();

        for (List<Integer> subset : ans) {

            Collections.sort(subset);

            uniqueSet.add(subset);
        }

        return new ArrayList<>(uniqueSet);
    }

    private void solve(int[] nums, int index, List<Integer> output) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

    
        // pick

        output.add(nums[index]);
        solve(nums, index + 1, output);
        output.removeLast(); 
        

         // not pick
        solve(nums, index + 1, output);
    }
}