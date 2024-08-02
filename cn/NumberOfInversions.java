/**
 * Similar to Merge Sort.
 * Time complexity = O(NlogN)
 * Space complexity = O(N)
 * 
 * While merging the array counting can be optimised as both sides are already sorted.
 */

public class Solution {
    public static int numberOfInversions(int []a, int n) {
        return mergeAndCount(a, 0, n - 1);
    }

    private static int mergeAndCount(int[] a, int low, int high) {
        if (high <= low) {
            return 0;
        }
        int mid = (low + high) / 2;
        int count = 0;
        count += mergeAndCount(a, low, mid);
        count += mergeAndCount(a, mid + 1, high);

        //both sides are sorted. Need to merge and count
        int i = low;
        int j = mid + 1;
        int[] temp = new int[high - low + 1];
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] > a[j]) {
                count += (mid - i + 1); //Counting optimised as both sides are sorted.
                temp[k] = a[j];
                j++;
            } else {
                temp[k] = a[i];
                i++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }
        while (j <= high) {
            temp[k] = a[j];
            j++;
            k++;
        }
        for (k = 0; k < temp.length; k++) {
            a[low + k] = temp[k]; //to sort a array
        }
        return count;
    }
}