/* Solution 3 : There is one more binary search solution for this */

/* Solution 2 : Storing the index in max heap which satisfies the condition */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> ( Math.abs(x - arr[b]) - Math.abs(x - arr[a]) ));
        
        for (int i = 0; i < arr.length; i++) {
            int dist = Math.abs(x - arr[i]);
            if (pq.size() == k && dist < Math.abs(x - arr[pq.peek()]) ) {
                pq.poll();
            } else if (pq.size() == k) {
                continue;
            }
            pq.add(i);
        }
        
        List<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(arr[pq.poll()]);
        }
        Collections.sort(res);
        
        return res;
    }
}

/* Solution 1 : Storing the pair (dist, val) in max heap which satisfies the condition */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>( (a, b) -> (b[0] - a[0]) );
        
        for (int i = 0; i < arr.length; i++) {
            int dist = Math.abs(x - arr[i]);
            if (pq.size() == k && pq.peek()[0] > dist) {
                pq.poll();
            } else if (pq.size() == k) {
                continue;
            }
            Integer[] pair = { dist, arr[i] };
            pq.add(pair);
        }
        
        List<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()[1]);
        }
        Collections.sort(res);
        
        return res;
    }
}