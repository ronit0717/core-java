/* Solution 3: Using concept of next smaller element, single pass solution
TC = O(2*N), SC = O(N)

Algo:
1. For every index, find the next smaller element on left and right
2. If current element is smaller than stack.peek(), then it implies its the next smaller element for the element at stack.peek()
   Also for this element, the previous smaller element is the next element in the stack
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if(st.isEmpty() || heights[st.peek()] < heights[i]) {
                st.push(i);
                continue;
            }

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                //current index is the next smaller element
                int index = st.pop();
                int rb = i;
                //the next element in the stack is the index of the prev smaller element
                int lb = st.isEmpty() ? 0: st.peek() + 1;
                int area = heights[index] * (rb - lb);
                maxArea = Math.max(area, maxArea);
            }
            st.push(i);
        }
        //if elements left in stack, it implies those elements dont have a next smaller element
        while(!st.isEmpty()) {
            int index = st.pop();
            int rb = heights.length;
            int lb = st.isEmpty() ? 0 : st.peek() + 1;
            int area = heights[index] * (rb - lb);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}

/* Solution 2: Using concept of next smaller element, double pass solution

Steps:
1. Find left smaller element index (lsei), and fill the left boundary => 
    if stack empty => left boundary = 0
    else => left boundary = lsei + 1
2. Find right smaller element index (rsei), and fill the right boundary => 
    if stack empty => right boundary = N
    else => right boundary = rsei
3. Compute area, area = (rb[i] - lb[i])* height[i], find max area

example:
index 			0		1		2		3		4		5		6
height[]		2		1		5		6		2		3		1
--------------------------------------------------------------------
lsei[]			0		0		2		3		2		5		0
rsei[]			1		7		4		4		6		6		7
--------------------------------------------------------------------
area 			2		7		10		6		8		3		7

TC = O(2*N) for lsei + O(2*N) for rsei + O(N) for area = O(5N) = O(N)
SC = O(2*N) for two stacks = O(N)

How to compute Next smaller element, check this problem: 
https://github.com/ronit0717/core-java/blob/master/gfg/NextSmallerElement.java
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] rb = new int[heights.length]; //right boundary
        int[] lb = new int[heights.length]; //left boundary
        Stack<Integer> st = new Stack<>();

        //fill lb
        for (int i = 0; i < heights.length; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            int leftIndex = st.isEmpty() ? -1 : st.peek();
            lb[i] = leftIndex + 1;
            st.push(i);
        }

        //fill rb
        st = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            int rightIndex = st.isEmpty() ? heights.length : st.peek();
            rb[i] = rightIndex;
            st.push(i);
        }

        //compute area
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (rb[i] - lb[i]);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}


/* Solution 1 
Brute approach:
For every index, find the index on left and right which is smaller than the height of current index (by iteration)
area = height[currentIndex] * (rightSmallerIndex - leftSmallerIndex - 1)

Then find the max area for all the indices.
TC = O(N^2), SC = O(1)
*/

/* Solution 0: Brute Force
For every start index, compute the min height for every end index, then compute area
TC = O(N^2), SC = O(1)
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea  = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int width = j - i + 1;
                int area = minHeight * width;
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }
}