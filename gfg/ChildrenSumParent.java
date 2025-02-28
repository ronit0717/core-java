/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        if (root == null) {
            return 1;
        }
        if (root.left == null && root.right == null) { //leaf
            return 1;
        }
        int left = isSumProperty(root.left);
        if (left == 0) {
            return 0;
        }
        int right = isSumProperty(root.right);
        if (right == 0) {
            return 0;
        }
        int sum = (root.left == null ? 0 : root.left.data)
            + (root.right == null ? 0 : root.right.data);
        return sum == root.data ? 1 : 0;
    }
}