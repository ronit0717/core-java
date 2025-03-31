class Solution
{
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int[] inTime = new int[V];
        int[] minInTime = new int[V];
        Set<Integer> set = new HashSet<>();
        int[] time = {0};
        
        for (int i = 0; i < V; i++) {
            boolean visited = inTime[i] > 0;
            if(!visited) {
                dfs(i, -1, set, inTime, minInTime, time, adj);
            }
        }
        
        if (set.size() == 0) {
            ArrayList<Integer> list = new ArrayList<>(1);
            list.add(-1);
            return list;
        }
        return setToList(set);
    }
    
    private ArrayList<Integer> setToList(Set<Integer> set) {
        ArrayList<Integer> list = new ArrayList<>(set.size());
        for (Integer val : set) {
            list.add(val);
        }
        Collections.sort(list);
        return list;
    }
    
    private void dfs(int index, int prev, Set<Integer> set, int[] inTime, 
                    int[] minInTime, int[] time, ArrayList<ArrayList<Integer>> adj) {
            
        time[0] += 1;
        inTime[index] = time[0];
        minInTime[index] = time[0];
        int child = 0;
        for (Integer next : adj.get(index)) {
            if (prev == next) {
                continue;
            }
            boolean isNextVisited = inTime[next] != 0;
            if (!isNextVisited) {
                dfs(next, index, set, inTime, minInTime, time, adj);
                child++;
            }
            int nextMin = isNextVisited ? inTime[next] : minInTime[next];
            if(prev != -1 && !isNextVisited && nextMin >= inTime[index]) {
                //current node is articulation point
                set.add(index);
            }
            minInTime[index] = Math.min(minInTime[index], 
                    nextMin);
        }
        if (prev == -1 && child > 1) {
            //starting node is an articulation point
            set.add(index);
        }
    }
}