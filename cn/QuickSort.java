import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<Integer> quickSort(List<Integer> arr){
        // Write your code here.
        sort(arr, 0, arr.size() - 1);
        return arr;
    }

    private static void sort(List<Integer> arr, int low, int high) {
        if (high <= low) {
            return;
        }
        int pivot = swapPivot(arr, low, high);
        sort(arr, low, pivot - 1);
        sort(arr, pivot + 1, high);
    }

    private static int swapPivot(List<Integer> arr, int start, int end) {
        int pivot = arr.get(start);
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (i <= j && arr.get(i) <= pivot) {
                i++;
            }
            while (j >= i && arr.get(j) > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, start, j);
        return j;
    }

    private static void swap(List<Integer> arr, int p1, int p2) {
        int temp = arr.get(p1);
        arr.set(p1, arr.get(p2));
        arr.set(p2, temp);
    }
}