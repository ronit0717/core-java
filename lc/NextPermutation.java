//Solution 2: Optimized solution (TC = O(N), SC=O(1))

/*
Algo:
1. Find i from behind such that a[i] < a[i+1]. If there is no such i, skip step 2 and 3
2. Find j such that nums[j] > nums[i] and j should be to the right of i
3. Swap nums[i] and nums[j]
4. Reverse all element to the right of i

Number = 3421

  4  
 / \
3   2
     \
      1


Step 1: Here i will be pointing to 3
Step 2: j will be pointing to 4
Step 3: Swap 3 and 4, thus it becomes 4 321
Step 4: Reverse elements in the right of i => '321' , hence it becomes 4123

Intuition: My target is to find the next greater number that can be formed with the given 
numers 1,2,3 and 4
*/


//code
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        //Step 1: Find i from behind such that a[i] < a[i+1]. If there is no such i, then i becomes -1
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        
        if (i >= 0) { //i == -1 means that the greatest element is at the 0th index (or the last permutation)
            //Step 2: Find j such that nums[j] > nums[i] and j should be to the right of i
            int j = nums.length - 1;
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }
            
            //Step 3:Swap nums[i] and nums[j]
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        
        //Step 4: Reverse all elements to the right of i
        int start = i + 1;
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}


//Solution 1 : Brute force
//Algo: Find all permutations in order, compare the permutations, 
//and if match, the immediate next will be the answer


class Solution {
    public void nextPermutation(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        String original = sb.toString();
        
        Arrays.sort(nums);
        sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        List<String> permutations = getPermutation(sb.toString());
        
        boolean matchPrev = false;
        for (String perm : permutations) {
            if (matchPrev) {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = perm.charAt(i) - '0';
                }
                return;
            }
            if (perm.equals(original)) {
                matchPrev = true;
            }
        }
        for (String perm : permutations) {            
            for (int i = 0; i < nums.length; i++) {
                nums[i] = perm.charAt(i) - '0';
            }
            break;
        }
    }
    
    private static List<String> getPermutation(String input) {
        List<String> res = new LinkedList<>();
        if (input.length() == 1) {
            res.add(input);
            return res;
        }
        HashSet<String> hash = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            List<String> next = getPermutation(input.substring(0, i) + input.substring(i+1, input.length()));
            for (String n : next) {
                String set = c + n;
                if (hash.contains(set)) {
                    continue;
                }
                res.add(set);
                hash.add(set);
            }
        }
        return res; 
    }
}