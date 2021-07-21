/* Solution 3: Using concept of next smaller element, single pass solution
TC = O(2*N), SC = O(N)

Algo:
1. Loop from i = 0 .. N
	1.1 If stack is empty, push it in stack and continue to next iteration
	1.2	Else, while stack is not empty
			1.2.1 If the top element is >= currentElement, push current Element in stack and continue to
				  next iteration
			1.2.2 Else, pop the top element
				  For the top element, the current top will be the next smallest in left and current Element
				  will be the next smallest in the right
				  Compute area with formula, 
				   area = (rightSmallerElementIndex - leftSmallerElementIndex - 1) * height of top element
				  Update max area
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) { //one additional loop is there
            while(!st.isEmpty()) {
                if (i < heights.length && heights[i] >= heights[st.peek()]) {
                    break;
                } else {
                    int index = st.pop();
                    int rightSmallerIndex = i;
                    int leftSmallerIndex = (st.isEmpty()) ? -1 : st.peek();
                    int area = (rightSmallerIndex - leftSmallerIndex - 1) * heights[index];
                    maxArea = Math.max(area, maxArea);
                }
            }
            st.push(i);
        }
        return maxArea;   
    }
}

/* Solution 2: Using concept of next smaller element, double pass solution

Steps:
1. Find left smaller element index array (lsei), if no left smaller element available set lsei[i] = -1
2. Find right smaller element index array (rsei), if no right smaller element available set rsei[i] = N
3. Compute area, area = (rsei[i] - lsei[i] - 1)* height[i], find max area

example:
index 			0		1		2		3		4		5		6
height[]		2		1		5		6		2		3		1
--------------------------------------------------------------------
lsei[]			-1		-1		1		2		1		4		-1
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
        int n = heights.length;
        int[] rsei = getRightSmallerIndexArray(heights); //index of right smaller index
        int[] lsei = getLeftSmallerIndexArray(heights); //index of left smaller index
        
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = (rsei[i] - lsei[i] - 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
    
    private int[] getLeftSmallerIndexArray(int[] heights) {
        int[] lsei = new int[heights.length]; //index of left smaller element
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length;  i++) {
            lsei[i] = -1;
            while (!st.isEmpty()) {
                if (heights[st.peek()] < heights[i]) {
                    lsei[i] = st.peek();
                    break;
                } else {
                    st.pop();
                }
            }
            st.push(i);
        }
        return lsei;
    }
    
    private int[] getRightSmallerIndexArray(int[] heights) {
        int[] rsei = new int[heights.length]; //index of right smaller element
        Stack<Integer> st = new Stack<>();
        for (int i = heights.length - 1; i >= 0;  i--) {
            rsei[i] = heights.length;
            while (!st.isEmpty()) {
                if (heights[st.peek()] < heights[i]) {
                    rsei[i] = st.peek();
                    break;
                } else {
                    st.pop();
                }
            }
            st.push(i);
        }
        return rsei;
    }
}

/* Solution 1 
Brute approach:
For every index check the index on left and right which is smaller than the height of current index
area = height[currentIndex] * (rightSmallerIndex - leftSmallerIndex - 1)

Then find the max area for all the indices.
TC = O(N^2), SC = O(1)
*/