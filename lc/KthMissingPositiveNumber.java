//Main concept: At a given point, number of missing nums = a[i] - (i + 1). Hence we can determine the right index to the right of which we will find the missing number

//Solution 2: Binary Search TC = O(LogN)
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int missing = countMissing(arr, mid);
            if (missing >= k) {
                high = mid - 1;
            } else {
                index = mid;
                low = mid + 1;
            }
        }
        return (k + index + 1);
    }

    private int countMissing(int[] arr, int index) {
        return arr[index] - (index + 1);
    }
}

//Solution 1: TC = O(N)
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            int missingTillThisPoint = arr[i] - (i + 1); //Number of missing numbers till this point
            if (missingTillThisPoint >= k) {
                break;
            } else {
                index = i;
            }
        }
        int num = k + index + 1;
        return num;
    }
}