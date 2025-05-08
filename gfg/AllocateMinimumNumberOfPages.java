//Problem link: https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        if (arr.length < k) {
            return -1;
        }
        int min = Integer.MIN_VALUE;
        int max = 0;
        int sum = 0;
        for (int page : arr) {
            min = Math.max(page, min);
            sum += page;
        }
        max = sum;
        int ans = -1;
        while (min <= max) {
            int mid = (min + max) / 2;
            int count = countStudents(mid, arr);
            if (count > k) {
                min = mid + 1;
            } else {
                ans = mid; //if count < k, then also we can distribute the books to all the students, since 'mid' is the max page which can be allocated
                max = mid - 1; //in search for a better answer
            }
        }
        return ans; //will be equal to min (where min becomes greater than max)
        
    }
    
    private static int countStudents(int maxPage, int[] arr) {
        int count = 1;
        int currPage = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] + currPage) > maxPage) {
                count++;
                currPage = arr[i];
            } else {
                currPage += arr[i];
            }
        }
        return count;
    }
}