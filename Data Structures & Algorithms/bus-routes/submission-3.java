class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;

        Map<Integer, List<Integer>> stopToBusesList = getStopToBusList(routes);

        if (stopToBusesList.get(source) == null)
            return -1;

        boolean[] visited = new boolean[routes.length];

        Queue<Integer> q = new LinkedList<>();

        for (int bus : stopToBusesList.get(source)) {
            q.add(bus);
            visited[bus] = true;
        }

        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int bus = q.poll();
                for (int stop : routes[bus]) {
                    if (stop == target)
                        return count;
                    for (int newBus : stopToBusesList.get(stop)) {
                        if (!visited[newBus]) {
                            q.add(newBus);
                            visited[newBus] = true;
                        }
                    }
                }
            }

            count++;
        }

        return -1;
    }

    private Map<Integer, List<Integer>> getStopToBusList(int[][] routes) {
        Map<Integer, List<Integer>> stopToBusesList = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (stopToBusesList.get(stop) == null) {
                    List<Integer> al = new ArrayList<>();
                    al.add(i);
                    stopToBusesList.put(stop, al);
                } else {
                    stopToBusesList.get(stop).add(i);
                }
            }
        }

        return stopToBusesList;
    }
}