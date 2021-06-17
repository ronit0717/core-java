//Link : https://www.geeksforgeeks.org/flattening-a-linked-list/
/* Algo: Recursively Flattening the right node
TC = O(n*m)
SC = O(1)
*/

class GfG
{
    Node flatten(Node root)
    {
	// Your code here
	    return flattenUtil(root);
    }
    
    Node flattenUtil(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        
        root.next = flattenUtil(root.next);
        
        Node left = root;
        Node right = root.next;
        Node prev = null;
        
        while (right != null && left != null) {
            if (right.data < left.data) {
                if (prev == null) {
                    prev = right;
                    root = right;
                } else {
                    prev.bottom = right;   
                }
                prev = right;
                right = right.bottom;
            } else {
                if (prev == null) {
                    prev = left;
                    root = left;
                } else {
                    prev.bottom = left;   
                }
                prev = left;
                left = left.bottom;
            }
        }
        if (left != null) {
            prev.bottom = left;
        } else if (right != null) {
            prev.bottom = right;
        }
        
        return root;
    }
}