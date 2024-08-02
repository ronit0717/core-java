/* Solution 2: Similar, simplified */
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = buildNums(n);
        Map<Integer, Integer> countMap = buildFactorial(n);
        List<Integer> candidates = new LinkedList<>();
        return evaluate(nums, candidates, k - 1, countMap);
    }

    private String evaluate(List<Integer> nums, 
                            List<Integer> candidates, 
                            int k, //index starts with 0
                            Map<Integer, Integer> countMap) {
        if (nums.size() == 0) {
            return buildString(candidates);
        }
        int blockSize = countMap.get(nums.size() - 1);
        int offset = k / blockSize;
        int newk = k % blockSize;
        candidates.add(nums.get(offset));
        nums.remove(offset);
        return evaluate(nums, candidates, newk, countMap);
    }

    private String buildString(List<Integer> candidates) {
        StringBuffer sb = new StringBuffer();
        for (Integer i : candidates) {
            sb.append((char)(i + '0'));
        }
        return sb.toString();
    }

    private List<Integer> buildNums(int n) {
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        return nums;
    }

    private Map<Integer, Integer> buildFactorial(int n) {
        Map<Integer, Integer> fact = new HashMap();
        fact.put(0, 1);
        int p = 1;
        for (int i = 1; i <= n; i++) {
            p = p * i;
            fact.put(i, p);
        }
        return fact;
    }
}

/* Solution 1
Space complexity = O(N) for list + O(N) for map = O(N)
Time complexity = O(N) * O(N) to remove element from list = O(N^2)

Approach:
We have to fill N positions, filling numbers from 1 to N
Now for each choice in Nth position, there can be (N-1)! permutations for position 1 to N-1
Thus the index of the Nth element will be (k-1)/(N-1)!
Now for the next recursion (or next position), 
then new k will be (k % (N-1)!), and k % (N-1)! == 0, then k = (N-1)!
*/
class Solution {
    public String getPermutation(int n, int k) {
        HashMap<Integer, Integer> factorialMap = getFactorialMap(n);
        LinkedList<Integer> list = getNumList(n);
        StringBuilder sb = new StringBuilder();
        
        int count = k;
        getPermUtil(n, k, factorialMap, list, sb);
        
        return sb.toString();
    }
    
    private void getPermUtil(int count, int k, HashMap<Integer, Integer> map, LinkedList<Integer> list, StringBuilder sb) {        
        if (count == 0) {
            return;
        }
        int fact = map.get(count - 1);
        int index = (k-1) / fact;
        sb.append(list.remove(index));
        k = (k % fact) == 0 ? fact : (k % fact);
        getPermUtil(count - 1, k, map, list, sb);   
    }
    
    private HashMap<Integer, Integer> getFactorialMap(int n) {
        HashMap<Integer, Integer> factorialMap = new HashMap<>();
        factorialMap.put(0, 1);
        int num = 1;
        for (int i = 1; i < n; i++) {
            num *= i;
            factorialMap.put(i, num);
        }
        return factorialMap;
    }
    
    private LinkedList<Integer> getNumList(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        int num = 1;
        while (num <= n) {
            list.add(num);
            num++;
        }
        return list;
    }   
}