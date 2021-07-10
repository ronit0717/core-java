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