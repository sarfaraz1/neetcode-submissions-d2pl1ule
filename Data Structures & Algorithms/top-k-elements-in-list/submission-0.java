class Solution {
   public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreqMap = new HashMap<>();

        for (int num : nums) {
            numToFreqMap.put(num, numToFreqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    return numToFreqMap.get(a) - numToFreqMap.get(b);
                }
        );


        for (int key : numToFreqMap.keySet()) {
            pq.add(key);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i] = pq.poll();
            i++;
        }
        return result;
    }
}
