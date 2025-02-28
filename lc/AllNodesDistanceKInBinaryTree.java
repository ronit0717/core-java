/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution 2: BFS
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //Build Parent Map
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        parentMap.put(root, null);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    parentMap.put(node.left, node);
                    q.add(node.left);
                }
                if (node.right != null) {
                    parentMap.put(node.right, node);
                    q.add(node.right);
                }
            }
        }

        //Distance traversal BFS
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        q.add(target);
        visited.add(target);
        int dist = 0;
        while(!q.isEmpty()) {
            if(dist == k) {
                while(!q.isEmpty()) {
                    list.add(q.poll().val);
                }
                break;
            }
            dist++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    q.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    q.add(node.right);
                    visited.add(node.right);
                }
                TreeNode parent = parentMap.get(node);
                if(parent != null && !visited.contains(parent)) {
                    q.add(parent);
                    visited.add(parent);
                }
            }
        }
        return list;
    }
}

//Solution 1: DFS
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //Build Parent Map
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        parentMap.put(root, null);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    parentMap.put(node.left, node);
                    q.add(node.left);
                }
                if (node.right != null) {
                    parentMap.put(node.right, node);
                    q.add(node.right);
                }
            }
        }

        //Distance traversal
        Set<TreeNode> visited = new HashSet<>();
        return buildList(target, k, visited, parentMap);
    }

    private List<Integer> buildList(TreeNode node, 
                                    int k, 
                                    Set<TreeNode> visited, 
                                    Map<TreeNode, TreeNode> parentMap) {
        List<Integer> list = new LinkedList<>();
        if (node == null || visited.contains(node)) {
            return list;
        }
        visited.add(node);
        if (k == 0) {
            list.add(node.val);
            return list;
        }
        List<Integer> leftList = buildList(node.left, k - 1, visited, parentMap);
        List<Integer> rightList = buildList(node.right, k - 1, visited, parentMap);
        List<Integer> parentList = buildList(parentMap.get(node), k - 1, visited, parentMap);
        list.addAll(leftList);
        list.addAll(rightList);
        list.addAll(parentList);
        return list;
    }
}