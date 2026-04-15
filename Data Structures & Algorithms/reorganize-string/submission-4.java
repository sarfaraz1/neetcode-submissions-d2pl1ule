class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        if (n == 1)
            return s;

        Map<Character, Integer> charToFreqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            charToFreqMap.put(s.charAt(i), charToFreqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> { return b.freq - a.freq; });

        for (Map.Entry e : charToFreqMap.entrySet()) {
            pq.add(new Pair((char) e.getKey(), (int) e.getValue()));
        }

        if (pq.peek().freq > Math.ceil((double) n / 2)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            Pair first = pq.poll();
            Pair second = pq.poll();
            sb.append(first.c).append(second.c);
            if (--first.freq > 0)
                pq.add(first);
            if (--second.freq > 0)
                pq.add(second);
        }

        if (!pq.isEmpty()) {
            sb.append(pq.poll().c);
        }
        return sb.toString();
    }

    class Pair {
        Character c;
        Integer freq;

        Pair(Character c, Integer freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}