//https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1#

/* Solution 2
Approach using two stack
Fill stack 1 from right-left order

while stack 1 not empty, pop from stack 1, and push children of this element in stack2 in left-right order
while stack 2 not empty, pop from stack 2, and push children of this element in stack1 in right-left order
*/
class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form. 
    ArrayList<Integer> findSpiral(Node root) 
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Stack<Node> leftStack = new Stack<>();
        Stack<Node> rightStack = new Stack<>();
        
        rightStack.push(root);
        
        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            
            while(!leftStack.isEmpty()) {
                Node node = leftStack.pop();
                
                res.add(node.data);
                
                //its children will be printed from right to left
                if (node.left != null) {
                    rightStack.push(node.left);
                }
                
                if (node.right != null) {
                    rightStack.push(node.right);
                }
            }
            
            while(!rightStack.isEmpty()) {
                Node node = rightStack.pop();
                
                res.add(node.data);
                
                if (node.right != null) {
                    leftStack.push(node.right);
                }
                
                if (node.left != null) {
                    leftStack.push(node.left);
                }
            }
            
        }
        
        return res;
    }
}
 

/* Solution 1
Approach to use a stack and a queue

if a row is to be printed from right, we insert element in a stack such that root.left goes in first followed by root.right
if a row is to be printed from left, we insert element in a stack such that root.right goes in first followed by root.left

Levels are marked using a null node in the queue
if null encountered, empty the elements from the stack into the queue
add a null in the end
*/

class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean left = true;
        Stack<Node> st = new Stack<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        q.add(null);
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            if (node == null && st.isEmpty()) {
                continue;
            } else if (node == null) {
                while (!st.isEmpty()) {
                    q.add(st.pop());
                }
                q.add(null);
                left = !left;
                continue;
            }
            
            res.add(node.data);
            if (left && node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
            if (!left && node.right != null) {
                st.push(node.right);
            }
        }
        
        return res;
    }
}