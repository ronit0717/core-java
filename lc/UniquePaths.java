class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        Integer[][] mem = new Integer[m][n];
        return uniquePaths(m, n, mem);
    }
    
    private int uniquePaths(int m, int n, Integer[][] mem) {
        if( mem[m - 1][n - 1] != null ) {
            return mem[m - 1][n - 1];
        }
        if (m == 1 || n == 1) {
            mem[m - 1][n - 1] = 1;
            return 1;
        }
        
        mem[m - 1][n - 1] = uniquePaths(m-1, n, mem) + uniquePaths(m, n-1, mem);
        return mem[m - 1][n - 1];
    }
}

/*

            eg: fn(2, 3) = 3
                /      \
               /        \  
              /          \
            fn(1, 3)    fn(2, 2)  
                         /     \
                        /       \
                     fn(1, 2)   fn(2, 1)

*/