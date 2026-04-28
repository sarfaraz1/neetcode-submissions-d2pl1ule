class Solution {
    int[] inDegree;

    int[] arr;
    ArrayList al = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        inDegree = new int[numCourses];
        arr = new int[numCourses];

        List<List<Integer>> adj = convertToAdjancyList(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            for (int neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }

        }

        bfs(adj);


        if (al.size() == numCourses) {
            for (int i = 0; i < al.size(); i++) {
                arr[i] = (int) al.get(i);
            }
            return arr;
        } else
            return new int[0];
    }

    private void bfs(List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            al.add(node);
            for (int neighbour : adj.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0)
                    q.add(neighbour);
            }
        }


    }

    private List<List<Integer>> convertToAdjancyList(int V, int[][] edges) {
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            al.add(new ArrayList<>());

        }
        for (int[] edge : edges) {
            int u = edge[1];
            int v = edge[0];

            al.get(u).add(v);
        }

        return al;

    }
}
