class LRUCache {
    
    class Node {
        Node next;
        Node prev;
        Integer key;
        Integer value;
        
        Node(Integer key, Integer val) {
            this.next = null;
            this.prev = null;
            this.key = key;
            this.value = val;
        }
    }
    
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(null, null);
        tail = new Node(null, null);
        map = new HashMap<>();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if (map.containsKey(key)) {
            Node n = map.get(key);
            makeNodeRecentlyUsed(n);
            return n.value;
        }
        
        return -1; //if key not present
    }
    
    public void put(int key, int value) {
        
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            makeNodeRecentlyUsed(n);
            return;
        }
        
        //Making new node
        if (map.size() == capacity) {
            //least recent used to be deleted
            Node lruNode = tail.prev;
            map.remove(lruNode.key);
            deleteNode(lruNode); 
        }
        
        //insert new node as recently used
        Node n = new Node(key, value);
        insertNodeRecentlyUsed(n);
        
        //put key value in the hashmap
        map.put(key, n);
    }
    
    private void makeNodeRecentlyUsed(Node n) {
        deleteNode(n);
        insertNodeRecentlyUsed(n);
    }
    
    private void deleteNode(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    private void insertNodeRecentlyUsed(Node n) {
        n.next = head.next;
        head.next = n;
        n.prev = head;
        n.next.prev = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */