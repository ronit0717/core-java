/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return "#,";
        }
        q.add(root);
        sb.append(root.val).append(",");
        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode node = q.poll();
            if (node.left == null) {
                sb.append("#");
            } else {
                sb.append(node.left.val);
                q.add(node.left);
            }
            sb.append(",");
            if (node.right == null) {
                sb.append("#");
            } else {
                sb.append(node.right.val);
                q.add(node.right);
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        int i = 1 ;
        TreeNode root = null;
        if(dataArr.length == 0 || dataArr[0].equals("#")) {
            return root;
        }
        int val = Integer.parseInt(dataArr[0]);
        root = new TreeNode(val);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty() && i < dataArr.length - 1) {
            int size = q.size();
            TreeNode node = q.poll();
            TreeNode leftNode = dataArr[i].equals("#") ? null 
                                    : new TreeNode(Integer.parseInt(dataArr[i]));
            TreeNode rightNode = dataArr[i + 1].equals("#") ? null 
                                    : new TreeNode(Integer.parseInt(dataArr[i + 1]));
            node.left = leftNode;
            node.right = rightNode;
            if (leftNode != null) {
                q.add(leftNode);
            }
            if (rightNode != null) {
                q.add(rightNode);
            }
            i+=2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));