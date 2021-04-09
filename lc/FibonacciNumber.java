class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int mem[] = new int[n + 1];
        mem[0] = 0;
        mem[1] = 1;
        return fib(n, mem);
    }

    private int fib(int n, int[] mem) {
        if (n==0 || mem[n] != 0) {
            return mem[n];
        }
        int a = fib((n - 2), mem);
        int b = fib((n - 1), mem);
        mem[n] = a + b;
        return mem[n];
    }
}