//Solution 2: Djisktra's Algorithm using a normal queue
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<Integer[]> q = new LinkedList<>();
        List<List<Integer[]>> adj = getAdjList(n, flights);
        int[] costArr = initCostArr(n);
        costArr[src] = 0;
        q.add(new Integer[]{src, 0, 0}); //location, cost and stop
        boolean reached = false;
        while(!q.isEmpty()) {
            Integer[] node = q.poll();
            int location = node[0];
            int cost = node[1];
            int stop = node[2];
            if (location == dst) {
                reached = true;
                continue;
            }
            for (Integer[] next : adj.get(location)) {
                int nextLocation = next[0];
                int nextPrice = next[1];
                int newCost = cost + nextPrice;
                if (stop <= k && newCost < costArr[nextLocation]) {
                    costArr[nextLocation] = newCost;
                    q.add(new Integer[]{nextLocation, newCost, stop + 1});
                }
            }
        }
        return reached ? costArr[dst] : -1;
    }

    private int[] initCostArr(int n) {
        int[] costArr = new int[n];
        for (int i = 0; i < n; i++) {
            costArr[i] = Integer.MAX_VALUE;
        }
        return costArr;
    }

    private List<List<Integer[]>> getAdjList(int n, int[][] flights) {
        List<List<Integer[]>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new LinkedList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int price = flights[i][2];
            adj.get(src).add(new Integer[]{dest, price});
        }
        return adj;
    }
}

//Solution 1: Normal BFS
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<Integer[]> q = new LinkedList<>();
        List<List<Integer[]>> adj = getAdjList(n, flights);
        q.add(new Integer[]{src, 0}); //location and cost
        int stops = -1;
        int minCost = Integer.MAX_VALUE;
        boolean reached = false;
        while(!q.isEmpty()) {
            if (stops > k) {
                break;
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer[] node = q.poll();
                int location = node[0];
                int cost = node[1];
                if (location == dst) {
                    reached = true;
                    minCost = Math.min(minCost, cost);
                    continue;
                }
                for (Integer[] next : adj.get(location)) {
                    int nextLocation = next[0];
                    int nextPrice = next[1];
                    int newCost = cost + nextPrice;
                    if (reached && newCost >= minCost) {
                        continue;
                    }
                    q.add(new Integer[]{nextLocation, newCost});
                } 
            }
            stops++;
        }
        return reached ? minCost : -1;
    }

    private List<List<Integer[]>> getAdjList(int n, int[][] flights) {
        List<List<Integer[]>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new LinkedList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int price = flights[i][2];
            adj.get(src).add(new Integer[]{dest, price});
        }
        return adj;
    }
}