//IN ORDER
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(A);
        while (A.left != null) {
            A = A.left;
            st.push(A);
        }
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            res.add(curr.val);
            if (curr.right != null) {
                curr = curr.right;
                st.push(curr);
                while (curr.left != null) {
                    curr = curr.left;
                    st.push(curr);
                }
            }
            
        }
        return res;
    }
}

//PRE ORDER
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(A);
        res.add(A.val);
        while (A.left != null) {
            A = A.left;
            st.push(A);
            res.add(A.val);
        }
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            if (curr.right != null) {
                curr = curr.right;
                res.add(curr.val);
                st.push(curr);
                while (curr.left != null) {
                    curr = curr.left;
                    res.add(curr.val);
                    st.push(curr);
                }
            }
        }
        return res;
    }
}

//POST ORDER

//Using two stack
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(A);
        while (!st1.isEmpty()) {
            TreeNode curr = st1.pop();
            if (curr.left != null) {
                st1.push(curr.left);
            }
            if (curr.right != null) {
                st1.push(curr.right);
            }
            st2.push(curr);
        }
        while (!st2.isEmpty()) {
            res.add(st2.pop().val);
        }
        return res;
    }
}

//Using 1 stack
public ArrayList<Integer> postorderTraversal(TreeNode A) {
    ArrayList<Integer> res = new ArrayList<>();
    Stack<TreeNode> st = new Stack<>();
    st.push(A);
    while (A.left != null) {
        A = A.left;
        st.push(A);
    }
    TreeNode prev = null;
    while (!st.isEmpty()) {
        TreeNode curr = st.peek();
        if ( ( curr.left == prev || curr.left == null) && curr.right != null && prev != curr.right ) {
            //go right
            curr = curr.right;
            st.push(curr);
            while (curr.left != null) {
                curr = curr.left;
                st.push(curr);
                prev = curr;
            }
        } else { //condition (curr.right == prev || curr.right == null) {
            //print root
            res.add(curr.val);
            prev = st.pop();
        }
    }
    return res;
}

//Using 1 stack and a hash map
void postOrder(TreeNode root) { 
    Stack<TreeNode> st = new Stack<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    st.push(root);
    map.put(root.value, 0);
    while(!st.isEmpty()) {
        TreeNode node = st.peek();
        int count = map.get(node.value);
        if (count == 0) {
            //move left
            if (node.left != null) {
                st.push(node.left);
                map.put(node.left.value, 0);
            }
            map.put(node.value, 1);
        } else if (count == 1) {
            //move right
            if (node.right != null) {
                st.push(node.right);
                map.put(node.right.value, 0);
            }
            map.put(node.value, 2);
        } else {
            //print node and pop
            System.out.println(node.value);
            st.pop();
        }
    }
} 