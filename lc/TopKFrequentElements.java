/* Solution 3 (Bucket Sort) TC ~ O(N) */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        LinkedList<Integer>[] bucket = new LinkedList[nums.length + 1]; //at max freq can be equal to N
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            count++;
            map.put(nums[i], count);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (bucket[count] == null) {
                bucket[count] = new LinkedList<>();
            }
            bucket[count].add(num);
        }
        int[] ans = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 0; i--) {
            List<Integer> cands = bucket[i];
            if (cands == null) {
                continue;
            }
            for (Integer cand : cands) {
                ans[index] = cand;
                index++;
                if (index == k) {
                    return ans;
                }
            }
        }
        return ans;
    }
}

/* Solution 2 (PQ Min Heap) TC = O(NLogK) */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a , b) -> (a[1] - b[1])); //min heap
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = freq.getOrDefault(nums[i], 0);
            count++;
            freq.put(nums[i], count);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (pq.size() < k) {
                pq.add(new Integer[]{key, value});
            } else if (pq.size() == k && pq.peek()[1] < value) {
                pq.poll();
                pq.add(new Integer[]{key, value});
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}

/* Solution 1 (Priority Queue - Max Heap) TC = O(NLogN) */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b) -> (b[1] - a[1])); //max heap
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = freq.getOrDefault(nums[i], 0);
            count++;
            freq.put(nums[i], count);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            pq.add(new Integer[]{key, value});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}