public class Solution {
    public ArrayList<String> prefix(ArrayList<String> A) {
        HashMap<Character, Node> dict = new HashMap<>(); //root
        for (String s : A) {
            Node curr = null;
            if (dict.containsKey(s.charAt(0))) {
                curr = dict.get(s.charAt(0));
            } else {
                curr = new Node(s.charAt(0));
                dict.put(s.charAt(0), curr);
            }
            for (int i = 1; i < s.length(); i++) {
                if (curr.childMap.containsKey(s.charAt(i))) {
                    curr = curr.childMap.get(s.charAt(i));
                } else {
                    Node newNode = new Node(s.charAt(i));
                    curr.childMap.put(s.charAt(i), newNode);
                    curr = newNode;
                }
            }
        }
        
        
        ArrayList<String> res = new ArrayList<>();
        for (String s : A) {
            Node curr = dict.get(s.charAt(0));
            StringBuilder sb = new StringBuilder();
            sb.append(curr.c);
            for (int i = 1; i < s.length(); i++) {
                if (numWords(curr) == 1) {
                    break;
                }
                curr = curr.childMap.get(s.charAt(i));
                sb.append(curr.c);
            }
            res.add(sb.toString());
        }
        return res;
    }
    
    private static int numWords(Node n) {
        int count = 0;
        for (Map.Entry<Character, Node> set : n.childMap.entrySet()) {
            count+= numWords(set.getValue());
        }
        return count == 0 ? 1 : count;
    }
    
    class Node {
        HashMap<Character, Node> childMap;
        Character c;
        
        Node() {
            c = null;
            childMap = new HashMap<>();
        }
        
        Node(Character ch) {
            c = ch;
            childMap = new HashMap<>();
        }
        
        void addChild(char ch, Node childNode) {
            childMap.put(ch, childNode);
        }
        
        boolean isComplete() {
            return childMap.size() == 0;
        }
    }
}
