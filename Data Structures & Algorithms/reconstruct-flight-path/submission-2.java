class Solution {
Map<String, List<String>> map;
    int ticketCount = 0;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = convertToAdjMap(tickets);
        ticketCount = tickets.size();

        List<String> path = new ArrayList<>();

        dfs(path, "JFK");
        return path;

    }

    boolean dfs(List<String> path, String from) {
        path.add(from);
        if (ticketCount + 1 == path.size()) {
            return true;
        }

        List<String> destList = map.get(from);
        if (destList == null) {
            path.remove(path.size() - 1);
            return false;

        }

        for (int i = 0; i < destList.size(); i++) {
            String dest = destList.get(i);
            destList.remove(i);
            if (dfs(path, dest)) return true;
            destList.add(i, dest);
        }

        path.remove(path.size() - 1);
        return false;
    }

    private Map<String, List<String>> convertToAdjMap(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new ArrayList<String>()).add(ticket.get(1));
        }


        // lexicographically sorted
        for (List<String> list : map.values()) {
            Collections.sort(list);
        }


        return map;
    }
}
