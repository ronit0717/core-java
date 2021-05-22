class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int index = -1;
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] res = new int[V];
        index = res.length - 1;
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (index < 0) {
                break;
            }
            DFSUtil(visited, res, i, adj);
        }
        return res;
        
    }
    
    private static void DFSUtil(boolean[] visited, 
                                int[] res,
                                int curr, 
                                ArrayList<ArrayList<Integer>> adj) {
        if (visited[curr]) {
            return;
        }
        visited[curr] = true;
        ArrayList<Integer> next = adj.get(curr);
        for (Integer n : next) {
            DFSUtil(visited, res, n, adj);
        }
        res[index] = curr;
        index--;
    }
}