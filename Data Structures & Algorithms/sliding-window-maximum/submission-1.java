class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int i = 0, j = 0;

        while (j < n) {
            int windowSize = j - i + 1;

            while (!q.isEmpty() && q.peekLast() < nums[j]) {
                q.pollLast();
            }
            q.add(nums[j]);
            if (windowSize < k) {
                j++;
            } else if (windowSize == k) {
                ans[i] = q.peekFirst();
                if (q.peekFirst() == nums[i]) {
                    q.pollFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
