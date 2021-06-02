//Link: https://www.geeksforgeeks.org/counting-inversions/

//Solution 2: Using merge sort, TC = O(NlogN), SC = O(N)
/*
Algo: While merging the two sorted array, we can easily count pairs in wrong order by just using the length, no need to check each and every element.
*/

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long[] temp = new long[(int)N];
        return mergeUtil(arr, temp, 0, (int)N-1);
        
    }
    
    static long mergeUtil(long arr[], long temp[], int start, int end) {
        if (start >= end) {
            return 0;
        }
        long count = 0;
        int mid = (start + end) / 2;
        count += mergeUtil(arr, temp, start, mid);
        count += mergeUtil(arr, temp, mid+1, end);
        
        int i = start;
        int j = mid+1;
        
        for (int k = start; k <= end ; k++) {
            if (i > mid) {
                temp[k] = arr[j++];
            } else if (j > end) {
                temp[k] = arr[i++];
            } else {
                if (arr[i] <= arr[j]) {
                    temp[k] = arr[i++];
                } else {
                    count += (mid - i + 1);
                    temp[k] = arr[j++];
                }
            }
        }
        
        for (int k = start; k <= end; k++) {
            arr[k] = temp[k];
        }
        
        return count;
    }
}


//Solution 1: Brute Force TC = O(N^2) , SC = O(1)
class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long count = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    count++;
                }
            }
        }
        return count;
    }
}

