//Soltion 2 TC = O(n),  using only minima
/*
1. Set first element as minima, and set profit = 0
2. Iterate rest of the elements
    2.1 If curr value less than minima -> update minima, and continue to next element
    2.2 Compute currentProfit = currValue - minima, if currProfit > profit -> Update profit
3. Return profit
*/
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                continue;
            }
            int currProfit = prices[i] - min;
            profit = Math.max(currProfit, profit);
        }
        
        return profit;
    }
}


//Solution 1 TC = O(n), SC = O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int max = prices[0];
        int min = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = -1;
                continue;
            }
            if (prices[i] > max) {
                max = prices[i];
                int newProfit = max-min;
                profit = Math.max(newProfit, profit);
            }
        }
        
        return profit;
        
    }
}

//Solution 0: Brute force O(n^2)
/*
for every i , in the right of i find j 
such that arr[j] > arr[i], profit = Max(profit, arr[j] - arr[i])
*/