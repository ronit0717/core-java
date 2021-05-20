void DFSUtil(int curr, Integer[] visited, int index)
	{
		if (visited[curr] != null) {
          return;
        }
      	visited[curr] = index;
        ArrayList<Integer> next = adjListArray.get(curr);
      	for (Integer n : next) {
        	DFSUtil(n, visited, index);
        }
	}
  
	void connectedComponents()
	{
		Integer[] visited = new Integer[V];
		for (int i = 0; i < V; i++) {
          DFSUtil(i, visited, i);
        }
		int count = 1;
      	Arrays.sort(visited);
      	for (int i = 1; i < visited.length; i++) {
			if (visited[i] > visited[i-1]) {
            	count++;
            }
        }
      	System.out.println("Number of distinct components: "+count);
	}