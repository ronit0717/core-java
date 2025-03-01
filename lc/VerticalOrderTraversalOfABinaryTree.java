/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//Solution 2 (Using Level Order Traversal)
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Object[]> q = new LinkedList<>();
        Object[] rootObjArr = {root, 0, 0};
        q.add(rootObjArr);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Object[] nodeArr = q.poll();
                TreeNode node = (TreeNode)nodeArr[0];
                int level = (int)nodeArr[1];
                int axis = (int)nodeArr[2];

                if (node.left != null) {
                    Object[] leftObjArr = {node.left, level + 1, axis - 1};
                    q.add(leftObjArr);
                }
                if (node.right != null) {
                    Object[] rightObjArr = {node.right, level + 1, axis + 1};
                    q.add(rightObjArr);
                }

                TreeMap<Integer, List<Integer>> axisMap = 
                    map.containsKey(axis) ? map.get(axis) : new TreeMap<>();
                List<Integer> data = axisMap.containsKey(level) ? axisMap.get(level) : new LinkedList<>();
                data.add(node.val);
                Collections.sort(data);
                axisMap.put(level, data);
                map.put(axis, axisMap);
            }
        }
        //evaluate result
        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
            TreeMap<Integer, List<Integer>> axisMap = entry.getValue();
            List<Integer> axisData = new LinkedList<>();
            for (Map.Entry<Integer, List<Integer>> subEntry : axisMap.entrySet()) {
                List<Integer> levelData = subEntry.getValue();
                axisData.addAll(levelData);
            }
            result.add(axisData);
        }
        return result;
    }
}

//Solution 1 (Using DFS)
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        int[] minMaxPos = new int[2];
        
        HashMap<Integer, ArrayList<Integer[]>> map = new HashMap<>();
        
        int level = 0;
        
        ArrayList<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{level, root.val});
        
        map.put(0, list);
        minMaxPos[0] = 0;
        minMaxPos[1] = 0;
        
        
        vTraversalUtil(root.left, -1, map, minMaxPos, level+1);
        vTraversalUtil(root.right, 1, map, minMaxPos, level+1);
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = minMaxPos[0]; i <= minMaxPos[1]; i++) {
            List<Integer> sortedList = new ArrayList<>();
            List<Integer[]> originalList = map.get(i);
            for (Integer[] element : originalList) {
                sortedList.add(element[1]);
            }
            res.add(sortedList);
        }
        return res;
    }
    
    private static void vTraversalUtil(TreeNode node, 
                                       int pos, 
                                       HashMap<Integer, ArrayList<Integer[]>> map,
                                       int[] minMaxPos, 
                                       int level) {
        if (node == null) {
            return;
        }
        ArrayList<Integer[]> list = null;
        if (map.get(pos) != null) {
            list = map.get(pos);
        } else {
            list = new ArrayList<>();
        }
        
        int i = 0;
        boolean done = false;
        while (i < list.size() && !done) {
            if (level == list.get(i)[0] && list.get(i)[1] > node.val) {
                list.add(i, new Integer[]{ level, node.val });
                done = true;
            } else if (level < list.get(i)[0]) {
                list.add(i, new Integer[]{ level, node.val });
                done = true;
            }
            i++;
        }
        
        if (!done) {
            list.add(new Integer[]{level, node.val});
        }
        
        if (pos < minMaxPos[0]) {
            minMaxPos[0] = pos;
        }
        
        if (pos > minMaxPos[1]) {
            minMaxPos[1] = pos;
        }
        
        map.put(pos, list);
        
        vTraversalUtil(node.left, pos-1, map, minMaxPos, level+1);
        vTraversalUtil(node.right, pos+1, map, minMaxPos, level+1);
    }
}