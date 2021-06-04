//Solution 2: Using permutation combination TC = O(Math.min(m, n)), SC = O(1)
/*
Total steps = total right count + total down count
Now in these total steps, some positions will be filled by R's and some by D's,
hence total such combinations = totalCount-C-rightCount * (totalCount-rightCount)-C-downCount
                                = totalCOunt-C-rightCount * 1
                                = totalCount-C-rightCount = totalCount-C-downCount

example: m = 2, n = 3

hence 
totalRightCount = n - 1 = 2
totalDownCount = m - 1 = 1
hence totalCount = 2 + 1  = 3

All possible combinations can be RRD, RDR, DRR
Hence total count = 3 = 3-C-2 = 3-C-1
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int rightCount = n - 1;
        int downCount = m - 1;
        int totalCount = rightCount + downCount;
        
        int count = Math.min(rightCount, downCount);
        
        //Finding totalCount-C-count
        long numerator = 1L;
        for (int i = 0; i < count; i++) {
            numerator *= totalCount;
            totalCount--;
        }
        
        long denom = 1L;
        for (int i = 2; i <= count; i++) {
            denom *= i;
        }
        
        return (int)(numerator / denom);
        
    }
}


//Solution 1: DP Approach, TC = O(m*n), SC = O(m*n)
class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<Integer, Integer> mem = new HashMap<>();
        return uniquePathUtil(m, n, 0, 0, mem);
    }
    
    private int getKey(int i, int j, int n) {
        return i*n + j;
    }
    
    private int uniquePathUtil(int m, int n, int i, int j, HashMap<Integer, Integer> mem) {
        int key = getKey(i, j, n);
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        if (i == m-1 || j == n-1) {
            return 1;
        }
        int count = uniquePathUtil(m, n, i + 1, j, mem) + uniquePathUtil(m, n, i, j + 1, mem);
        mem.put(key, count);
        return count;
    }
}

/*

m = 2 (number of rows), n = 3 (number of columns)

            eg: fn(0, 0) = 3
                /      \
               /        \  
              /          \
        1 = fn(1, 0)    fn(0, 1) = 2 
                         /     \
                        /       \
                 1 = fn(1, 1)   fn(0, 2) = 1

*/