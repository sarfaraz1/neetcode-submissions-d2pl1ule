class Solution {
  int rowSize, colSize;
    int[] price;

    int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        rowSize = flights.length;
        colSize = flights[0].length;

        price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);

        List<List<FlightData>> adj = convertToAdjancyList(n, flights);

        bfs(adj, src, dst, k);

        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
    }


    private void bfs(List<List<FlightData>> adj, int src, int dst, int k) {
        Queue<ComputedData> q = new LinkedList();
        q.add(new ComputedData(0, src, 0));
        price[src] = 0;


        while (!q.isEmpty()) {
            ComputedData curr = q.poll();

            if (curr.stop > k) continue;
            for (FlightData flight : adj.get(curr.node)) {
                int newPrice = curr.price + flight.price;
                if (newPrice < price[flight.destination]) {
                    price[flight.destination] = newPrice;
                    q.add(new ComputedData(curr.stop + 1, flight.destination, newPrice));
                }
            }
        }
    }

    class FlightData {
        int destination;
        int price;

        FlightData(int destination, int price) {
            this.destination = destination;
            this.price = price;
        }

    }

    class ComputedData {
        int stop;
        int node;
        int price;

        ComputedData(int stop, int node, int price) {
            this.stop = stop;
            this.node = node;
            this.price = price;
        }

    }


    private List<List<FlightData>> convertToAdjancyList(int n, int[][] flights) {
        List<List<FlightData>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];

            al.get(u).add(new FlightData(v, price));
        }

        return al;
    }
}
