class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (x, y) -> {
                    return y.freq - x.freq;
                }
        );

        if (a > 0) pq.add(new Pair('a', a));
        if (b > 0) pq.add(new Pair('b', b));
        if (c > 0) pq.add(new Pair('c', c));

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p1 = pq.poll();
            if (sb.length() < 2 || (sb.charAt(sb.length() - 1) != p1.c || sb.charAt(sb.length() - 2) != p1.c)) {
                sb.append(p1.c);
                if (--p1.freq != 0) pq.add(p1);
            } else if (!pq.isEmpty()) {
                Pair p2 = pq.poll();
                sb.append(p2.c);
                if (--p2.freq != 0) pq.add(p2);
                pq.add(p1);
            }
        }

        return sb.toString();
    }

    class Pair {
        char c;
        int freq;

        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}