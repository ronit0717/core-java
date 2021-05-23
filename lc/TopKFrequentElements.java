/* Solution 1 (Priority Queue - Lambda Comparator) */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int res[] = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
            new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, List<Integer>> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (map.containsKey(nums[i])) {
                count += map.get(nums[i]);
            }
            map.put(nums[i], count);
        }
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            pq.add(set);
        }
        int count = 0;
        while (count < k) {
            Map.Entry<Integer, Integer> set = pq.poll();
            res[count++] = set.getKey();
        }
        return res;
    }
}


/* Solution 0 (Priority Queue) */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int res[] = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, List<Integer>> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (map.containsKey(nums[i])) {
                count += map.get(nums[i]);
            }
            map.put(nums[i], count);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            List<Integer> list;
            if (freqMap.containsKey(set.getValue())) {
                 list = freqMap.get(set.getValue());
            } else {
                pq.add(set.getValue());
                list = new ArrayList<Integer>();
            }
            list.add(set.getKey());
            freqMap.put(set.getValue(), list);
        }
        count = 0;
        while (count < k) {
            List<Integer> list = freqMap.get(pq.poll());
            for (Integer i : list) {
                res[count] = i;
                count++;
                if (count == k) {
                    break;
                }
            }
        }
        return res;
    }
}