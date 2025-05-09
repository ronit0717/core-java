//Problem link: https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1

//Solution 3: Optimal approach using binary search => TC = O(N) + OLog(Max Diff In Original Gas Stations). SC = O(1)
class Solution {
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        double minDiff = 1e-6;
        double low = 0d;
        double high = 0d;
        for (int i = 1; i < stations.length; i++) {
            int diff = stations[i] - stations[i - 1];
            high = Math.max(diff, high);
        }
        
        while ((high - low) > minDiff) {
            double mid = (high + low) / (2d);
            int count = countGasStations(stations, mid);
            if (count > k) {
                low = mid;
            } else {
                high = mid; //finally high will become the ans
                /*
                NOTE: It is possible that this else condition may never get executed.
                Since we are ensuring ((high - low) > minDiff), it is possible that
                always the if condition was satisfied, as a result the else block
                was never executed. Hence here we cannot keep a 'ans' variable. Instead
                we have to rely on the 'high' variable to store the answer.
                */
            }
        }
        return high;
    }
    
    private static int countGasStations(int[] stations, double dist) {
        int count = 0;
        for (int i = 1; i < stations.length; i++) {
            int diff = stations[i] - stations[i - 1];
            int delta = (int)(diff / dist);
            if (diff % dist == 0) {
                delta--;
                /*
                Example: 1 / 0.4 = 2 (we can place two gas stations)
                But 1 / 0.5 = 2 (but here we can place only 1 gas station. Hence if perfectly
                divisible, we decrement the delta
                */
            }
            count += delta;
        }
        return count;
    }
}


//Solution 2: Better approach using heap => TC = O(NLogN) + O(K*LogN). SC = O(N) for the heap
class Solution {
    
    static class Pair implements Comparable<Pair> {
        double dist; 
        int index;
        
        public Pair(double dist, int index) {
            this.dist = dist;
            this.index = index;
        }
        
        @Override
        public int compareTo(Pair p) {
           return (p.dist).compare(this.dist);
        }
    }
    
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        
        int n = stations.length;
        int[] countBetween = new int[n - 1];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(); //max heap
        
        //Add the pair of (dist, index) in max heap
        for (int j = 1; j < n; j++) {
            double dist = (stations[j] - stations[j - 1]) / (countBetween[j - 1] + 1d);
            pq.add(new Pair(dist, j));
        }
        
        //Remove the max dist and add the gas stations k times
        for (int i = 0; i < k; i++) {
            Pair pair = pq.poll();
            int j = pair.index;
            countBetween[j - 1]++;
            double newDist = (stations[j] - stations[j - 1]) / (countBetween[j - 1] + 1d);
            pq.add(new Pair(newDist, j));
        }
        
        //compute max distance
        return pq.peek().dist;
    }
}

//Solution 1: Brute Approach => TC = O(N*k) + O(N)
class Solution {
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        
        int n = stations.length;
        int[] countBetween = new int[n - 1];
        
        //identify positions where k gas stations can be placed
        for (int i = 0; i < k; i++) {
            //compute candidate for placing -> stations with max distance
            double maxDist = -1;
            int maxIndex = -1;
            for (int j = 1; j < n; j++) {
                double dist = (stations[j] - stations[j - 1]) / (countBetween[j - 1] + 1d);
                if (dist > maxDist) {
                    maxDist = dist;
                    maxIndex = j - 1;
                }
            }
            countBetween[maxIndex]++;
        }
        
        //find max distance
        double maxDist = Double.MIN_VALUE;
        for (int j = 1; j < n; j++) {
            double dist = (stations[j] - stations[j - 1]) / (countBetween[j - 1] + 1d);
            maxDist = Math.max(maxDist, dist);
        }
        return maxDist;
    }
}
