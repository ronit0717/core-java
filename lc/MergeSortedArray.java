/* Leetcode */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int t1 = m - 1;
        int t2 = n - 1;
        int i = m + n - 1;
        while (t1 >= 0 && t2 >= 0) {
            if(nums1[t1] >= nums2[t2]) {
                nums1[i] = nums1[t1];
                t1--;
            } else {
                nums1[i] = nums2[t2];
                t2--;
            }
            i--;
        }
        while (t2 >= 0) {
            nums1[i] = nums2[t2];
            i--;
            t2--;
        }
    }
}

//Striver-D1-3

/*
GFG: https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1

*/
//Solution 1: T(n) : O(n^2) => Insertion sort
/* Algo: Idea is that the 0th element of second array should be smaller than all elements in 1st array
Traverse first array
if (ith element > 0th element of second array) {
    swap;
    sort the second array
}
*/
class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here 
        if (m == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (arr1[i] > arr2[0]) {
                long temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                int j = 1;
                while (j < m && arr2[j] < arr2[j-1]) {
                    arr2[j - 1] = arr2[j];
                    arr2[j] = temp;
                    j++;
                }
            }
        }
    }
}

//Soution 2: T(n) = O(nlogn) GAP Algorithm
/* Algo:
gap = (n + m is even) ? (n + m)/2 : (n + m)/2 + 1;
while (gap > 0) {
    check two elements in gap, swap if order incorrect
    gap = (gap is even) ? gap / 2 : gap/2 + 1;    
}
*/
class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here 
        int gap;
        if ((n + m) % 2 == 0) {
            gap = (n + m) / 2;
        } else {
            gap = (n + m) / 2 + 1;
        }
        while (gap > 0) {
            
            int i = 0;
            int j = i + gap;
            while (j < (n + m)) {
                if (i < n && j < n) {
                    if (arr1[i] > arr1[j]) {
                        long temp = arr1[j];
                        arr1[j] = arr1[i];
                        arr1[i] = temp;
                    }
                } else if (i < n && j >= n) {
                    if (arr1[i] > arr2[j - n]) {
                        long temp = arr2[j - n];
                        arr2[j - n] = arr1[i];
                        arr1[i] = temp;
                    }
                } else {
                    if (arr2[i - n] > arr2[j - n]) {
                        long temp = arr2[j - n];
                        arr2[j - n] = arr2[i - n];
                        arr2[i - n] = temp;
                    }
                }
                i++;
                j++;
            }
            
            if (gap % 2 == 0) {
                gap = gap / 2;
            } else if (gap == 1) {
                gap--;
            } else {    
                gap = gap / 2 + 1;
            }
        }
    }
}