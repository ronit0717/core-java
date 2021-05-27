//https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();
        long sum = ((long)n*((long)n+1))/2;
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                res[0] = arr[i];
                continue;
            }
            sum -= arr[i];
            set.add(arr[i]);
        }
        res[1] = (int)sum;
        return res;
    }
}