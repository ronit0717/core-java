class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() == (k + 1)) {
                arr[index] = pq.poll();
                index++;
            }
        }
        while(index < arr.length) {
            arr[index] = pq.poll();
            index++;
        }
    }
}
