class Solution {
      public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int gift : gifts) {
            pq.add(gift);
        }


        while (k > 0) {
            int gift = pq.poll();
            gift = (int) Math.floor(Math.sqrt(gift));
            pq.add(gift);
            k--;
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}