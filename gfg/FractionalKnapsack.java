//Link: https://www.geeksforgeeks.org/fractional-knapsack-problem/

/* Solution 1, TC = O(NLogN), SC = O(1)
Sort the array in decreasing order of absolute value ie, price / weight
Then we add the product(s) in knapsack in this order (highest value first)
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr, (a, b) -> 
            (
                (((double)b.value / (double)b.weight) - ((double)a.value / (double)a.weight)) >= 0.0 ? 1 : -1
            ));
        double sum = 0.0;
        double valueSum = 0.0;
        for (int i = 0; i < n; i++) {
            if (sum >= W) {
                break;
            }
            double diff = (double)W - sum;
            if (diff > arr[i].weight) {
                sum += (double)arr[i].weight;
                valueSum += (double)arr[i].value;
            } else {
                sum = (double)W;
                valueSum += ((double)arr[i].value * diff) / ((double)arr[i].weight); 
            }
        }
        return valueSum;
    }
}