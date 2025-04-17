class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int cap;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        Node node = map.getOrDefault(key, null);
        if (node == null) {
            return -1;
        }
        deleteNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            node.val = value;
            addNode(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() == cap) {
                Node deletedNode = deleteLast();
                map.remove(deletedNode.key);
            }
            map.put(key, node);
            addNode(node);
        }
    }

    private Node deleteLast() {
        Node deletedNode = tail.prev;
        deleteNode(tail.prev);
        return deletedNode;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //add node at beginning (after head)
    private void addNode(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}