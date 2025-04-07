//Link: https://www.geeksforgeeks.org/fractional-knapsack-problem/

/**
 * Solution 2 : Alternate solution, same approach as Solution 1
 */
class Unit implements Comparable<Unit> {
    int val;
    int wt;
    
    Unit(int val, int wt) {
        this.val = val;
        this.wt = wt;
    }
    
    @Override
    public int compareTo(Unit u) {
        double rate1 = (double)this.val / this.wt;
        double rate2 = (double)u.val / u.wt;
        if (rate2 == rate1) {
            return 0;
        } else if (rate2 > rate1) {
            return 1;
        }
        return -1;
    }
}

// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        List<Unit> unitList = buildUnitList(val, wt);
        double total = 0;
        int remainingCapacity = capacity;
        for (int i = 0; i < unitList.size(); i++) {
            if (remainingCapacity == 0) {
                break;
            }
            Unit u = unitList.get(i);
            if (remainingCapacity >= u.wt) {
                total += u.val;
                remainingCapacity -= u.wt;
            } else {
                total += ((double)u.val / u.wt) * remainingCapacity;
                remainingCapacity = 0;
            }
        }
        return total;
    }
    
    private List<Unit> buildUnitList(List<Integer> val, List<Integer> wt) {
        List<Unit> list = new ArrayList<>(val.size());
        for (int i = 0; i < val.size(); i++) {
            Unit u = new Unit(val.get(i), wt.get(i));
            list.add(u);
        }
        Collections.sort(list);
        return list;
    }
}

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