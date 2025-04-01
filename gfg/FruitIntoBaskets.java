//Solution 2: TC = O(N). Max window size remains fixed
class Solution {
    public static int totalElements(Integer[] arr) {
        // code here
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while(j < arr.length) {
            int fruit = arr[j];
            int count = map.getOrDefault(fruit, 0);
            count++;
            map.put(fruit, count);
            if (map.size() > 2) {
                int removeFruit = arr[i];
                count = map.get(removeFruit);
                count--;
                if (count == 0) {
                    map.remove(removeFruit);
                } else {
                    map.put(removeFruit, count);
                }
                i++;
            }
            if (map.size() <= 2) {
                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
            }
            j++;
        }
        return maxLen;
    }
}

//Solution 1: TC = O(2N)
class Solution {
    public static int totalElements(Integer[] arr) {
        // code here
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while(j < arr.length) {
            int fruit = arr[j];
            int count = map.getOrDefault(fruit, 0);
            count++;
            map.put(fruit, count);
            while(map.size() > 2) {
                int removeFruit = arr[i];
                count = map.get(removeFruit);
                count--;
                if (count == 0) {
                    map.remove(removeFruit);
                } else {
                    map.put(removeFruit, count);
                }
                i++;
            }
            int len = j - i + 1;
            maxLen = Math.max(len, maxLen);
            j++;
        }
        return maxLen;
    }
}