//https://www.geeksforgeeks.org/count-number-subarrays-given-xor/

/* TC = O(N)
Concept x ^ m = z , then y = z ^ x

As we loop we maintain the current xor from leftmost index to current index
If current xor == required xor, then increment count
Else If current xor ^ required xor is present in map, this means that all those subarrays
will also give me the required xor

nums  :	4	2	2	6	4
xor   :	4	6	4	2	6
xor^m :	2	0	2	4	0

All the substring that will give xor = 6
{4,2}
{4,2,2,6,4}
{2,2,6}
{6}
*/

import java.util.HashMap;

public class HelloWorld{

     public static void main (String[] args) {
	    int[] nums = {4, 2, 2, 6, 4};
	    int m = 6; //required xor
		HashMap<Integer, Integer> map = new HashMap<>();
		int substrCount = 0;
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
		    xor = xor ^ nums[i];
		    if (xor == m) {
		        substrCount++;
		    } else if (map.containsKey(xor ^ m)) {
		        substrCount += map.get(xor ^ m);
		    }
		    int count = 1;
		    if (map.containsKey(xor)) {
		        count += map.get(xor);
		    }
		    map.put(xor, count);
		}
		System.out.println(substrCount);
	}
	
}