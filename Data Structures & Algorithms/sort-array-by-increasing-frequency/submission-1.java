class Solution {
  public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> numToFreqMap = new HashMap<>();

        for (int num : nums) {
            numToFreqMap.put(num, numToFreqMap.getOrDefault(num, 0) + 1);
        }

        System.out.println("map: " + numToFreqMap);

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    int diff = numToFreqMap.get(a) - numToFreqMap.get(b);
                    if (diff == 0) {
                        return b - a;
                    }
                    return diff;
                }
        );


        for (int key : numToFreqMap.keySet()) {
            pq.add(key);
        }

        System.out.println("pq: " + pq);

        int[] result = new int[nums.length];
        int i = 0;

        while (!pq.isEmpty()) {
            int num = pq.poll();
            int freq = numToFreqMap.get(num);

            for (int j = 0; j < freq; j++) {
                result[i] = num;
                i++;
            }
        }

        return result;
    }
}