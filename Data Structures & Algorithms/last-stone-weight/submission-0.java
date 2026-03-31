class Solution {
       public int lastStoneWeight(int[] stones) {
        // max pq
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if (stone1 == stone2) continue;

            else if (stone1 > stone2)
                pq.add(stone1 - stone2);

            else
                pq.add(stone2 - stone1);
        }

        return pq.size() == 1 ? pq.peek() : 0;
    }
}