public class Solution {
  public int solve(ArrayList < Integer > A, int B) {
    HashMap<Integer, Integer> freq = new HashMap<>(); //freq of a xor
    int count = 0;
    int xor = 0;
    for (int i = 0; i < A.size(); i++) {
        xor = xor ^ A.get(i);
        if (xor == B) {
            count += 1;
        }
        
        int leftXor = B ^ xor;
        if (freq.containsKey(leftXor)) {
            count += freq.get(leftXor);
        }
        
        //add current xor to freq map
        int currXorCount = 1;
        if (freq.containsKey(xor)) {
            currXorCount += freq.get(xor);
        }
        freq.put(xor, currXorCount);
        
    }
    return count;
  }
}

/*

Explanation:
Traverse from left to right and compute the xor from 0 to currIndex (say = z), 
and store it in hashmap/or array (prefix array)

if the xor == B, then increase count

assume at between 0 to currIndex there is a pivot, which break the section into two contagious subarrays
say, xor from 0 to pivot = y
say, xor from pivot+1 to currIndex = B

now, y = B ^ z;
this means, whenever for an array from 0 to pivot the above equation holds true, 
then from pivot + 1 to currIndex, xor will be equal to B

We will get the freq of y from the prefix array/hashmap


*/