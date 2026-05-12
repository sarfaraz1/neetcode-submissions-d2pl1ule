/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;

        int maxSize = 1;

        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>(
                (a, b) -> {
                    return a.end - b.end;
                }
        );

        pq.add(new Interval(intervals.getFirst().start, intervals.getFirst().end));
        for (int i = 1; i < intervals.size(); i++) {
            if (pq.peek().end <= intervals.get(i).start)
                pq.poll();

            pq.add(new Interval(intervals.get(i).start, intervals.get(i).end));

            maxSize = Math.max(maxSize, pq.size());
        }

        return maxSize;
    }
}
