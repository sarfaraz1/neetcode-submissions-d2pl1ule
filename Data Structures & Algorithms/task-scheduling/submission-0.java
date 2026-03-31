class Solution {
 public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];

        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int freq : frequencies) {
            if (freq > 0)
                pq.add(freq);
        }

        int time = 0;
        int cycle = n + 1;
        while (!pq.isEmpty()) {
            int workDone = 0;
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    int freq = pq.poll();
                    if (freq - 1 > 0)
                        temp.add(freq - 1);

                    workDone++;

                }
            }

            for (int freq : temp)
                pq.add(freq);

            if (!pq.isEmpty())
                time += cycle;

            else
                time += workDone;

        }


        return time;

    }
}
