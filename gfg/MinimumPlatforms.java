//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/

//Solution 3 (Cleaner code): TC =  O(NLogN) + O(2N), SC = O(1)
class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0;
        int j = 0;
        int maxCount = 0;
        int count = 0;
        while(i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}

//Solution 2: TC = O(NLogN) + O(2N), SC = O(1)
/*
Sort both arrival and departure arrays
Iterate the arrival array, now if the arrival[i] <= departure[j], this implies that
there is a new arrival at that time, hence the number of platforms in use needs to be increased.
Else, it means that there is a departure happening hence the platform count needs to be decreased.

So we need to find the max number of platforms in use at a given time
*/
class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int j = 0;
        int maxPlatform = 0; //stores max of currPlatfrom in use at a given time
        int currPlatform = 0; //stores number of platforms currently in use
        for (int i = 0; i < n; i++) {
            while (dep[j] < arr[i]) { //this means some departures happened at this point of time
                currPlatform--;
                j++;
            }
            currPlatform++; //indicates an arrival
            maxPlatform = Math.max(maxPlatform, currPlatform);
        }
        
        return maxPlatform;
    }
    
}


//Solution 1: TC = O(NLogN), SC = O(N)
/*
Algo involves first sorting the array in ascending order of arrival times
Maintain a PriorityQueue (PQ), which holds the departure times, as we iterate the arrival times
*/
class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        
        if (n == 0) {
            return 0;
        }
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for( int i = 0; i < n; i++ ) {
            List<Integer> indexes;
            if (map.containsKey(arr[i])) {
                indexes = map.get(arr[i]);
            } else {
                indexes = new LinkedList<>();
            }
            indexes.add(i);
            map.put(arr[i], indexes);
        }
        //the tree map will ensure, we get all the indexes in sorted manner
        //index of early arrival will be first
        
        PriorityQueue<Integer> deps = new PriorityQueue<>(); //departure times in natural sorted order
        
        for (Map.Entry<Integer, List<Integer>> set : map.entrySet()) {
            List<Integer> indexes = set.getValue();
            for (Integer index : indexes) {
                for (Integer d : deps) {
                    if (arr[index] > d) {
                        deps.remove(d);
                        break;
                    }
                }
                deps.add(dep[index]);    
            }
        }
        
        return deps.size();
    }
    
}