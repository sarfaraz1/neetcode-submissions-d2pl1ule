class Solution {
public int[][] merge(int[][] intervals) {
        List<Pair> al = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            if (al.isEmpty() || al.getLast().endTime < interval[0]) {
                al.add(new Pair(interval[0], interval[1]));
            } else {
                al.getLast().endTime = Math.max(al.getLast().endTime, interval[1]);
            }
        }

        int[][] ans = new int[al.size()][2];
        for (int i = 0; i < al.size(); i++) {
            ans[i][0] = al.get(i).startTime;
            ans[i][1] = al.get(i).endTime;
        }

        return ans;

    }

    class Pair {
        int startTime;
        int endTime;

        public Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

    }
}
