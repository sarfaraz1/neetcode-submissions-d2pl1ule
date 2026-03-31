class Solution {
       public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int diff = Math.abs(b - x) - Math.abs(a - x);
            if (diff == 0) return b - a;
            return diff;
        });

        for (int ele : arr) {
            pq.add(ele);

            if (pq.size() > k)
                pq.poll();
        }

        List<Integer> al = new ArrayList<>();
        while (!pq.isEmpty()) {
            al.add(pq.poll());
        }
        Collections.sort(al);
        return al;
    }
}