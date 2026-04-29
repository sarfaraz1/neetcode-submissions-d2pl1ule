class Solution {
    int[] inDegree;
    StringBuilder sb = new StringBuilder();
    boolean isInvalid;

    public String foreignDictionary(String[] words) {

        List<List<Integer>> adj = createAdjList(words);

        if (isInvalid)
            return "";

        boolean[] present = new boolean[26];

        // finding which characters are present
        for (int i = 0; i < words.length; i++) {
            char[] charArr = words[i].toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                present[charArr[j] - 'a'] = true;
            }
        }


        inDegree = new int[26];

        for (int i = 0; i < 26; i++) {
            for (int neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }

        bfs(present, adj);

        // finding count of characters which are present
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (present[i] == true)
                count++;
        }

        return sb.length() == count ? sb.toString() : "";

    }

    private List<List<Integer>> createAdjList(String[] words) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];


            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                isInvalid = true;
            }


            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        return adj;
    }

    private void bfs(boolean[] present, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0 && present[i])
                q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append((char) (node + 'a'));
            for (int neighbour : adj.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0)
                    q.add(neighbour);
            }
        }


    }
}
