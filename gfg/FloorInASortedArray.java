class Solution {

    static int findFloor(int[] arr, int x) {
        // write code here
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}