class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        int[] ans = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    int diff = a.value - b.value;
                    if (diff == 0) return a.index - b.index;
                    return diff;
                }
        );

        for (int i = 0; i < n; i++) {
            Pair p = new Pair(nums[i], i);
            pq.add(p);
        }
        while (k > 0) {
            Pair p = pq.poll();
            p.value *= multiplier;
            pq.add(p);
            k--;
        }

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            ans[p.index] = p.value;
        }

        return ans;
    }

    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}