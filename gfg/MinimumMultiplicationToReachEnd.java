class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        if (start == end) {
            return 0;
        }
        int mod = 100000;
        int[] dist = initDist(mod);
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{start, 0});
        while(!q.isEmpty()) {
            Integer[] node = q.poll();
            int num = node[0];
            int currStep = node[1];
            for (int i = 0; i < arr.length; i++) {
                int nextStep = currStep + 1;
                int nextNum = (num * arr[i]) % mod;
                if (nextNum == end) {
                    return nextStep;
                }
                if (nextStep < dist[nextNum]) {
                    dist[nextNum] = nextStep;
                    q.add(new Integer[]{nextNum, nextStep});
                }
            }
        }
        return -1;
    }
    
    private int[] initDist(int size) {
        int[] dist = new int[size];
        for (int i = 0; i < size; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        return dist;
    }
}