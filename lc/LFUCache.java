class LFUCache {
    
    class Node {
        Node next;
        Node prev;
        int key;
        int value;
        int freq;
        
        Node(int key, int value) {
            this.next = null;
            this.prev = null;
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    
    class DLL { //Doubly Linked List
        Node head;
        Node tail;
        
        DLL() {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }
    }
    
    private int capacity;
    private TreeMap<Integer, DLL> freqMap;
    private HashMap<Integer, Node> map; //key - Node map

    public LFUCache(int capacity) {
        this.capacity = capacity;
        freqMap = new TreeMap<>();
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            increaseFrequency(n);
            return n.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            increaseFrequency(n);
            return;
        }
        if (map.size() == capacity) {
            deleteLFU();
        }
        Node n = new Node(key, value);
        insertNode(n);
        map.put(n.key, n);
    }
    
    private void deleteLFU() {
        DLL dll = freqMap.get(freqMap.firstKey());
        Node n = dll.tail.prev;
        deleteNode(n);
        map.remove(n.key);
    }
    
    private void increaseFrequency(Node n) {
        deleteNode(n);
        n.freq++;
        insertNode(n);
    }
    
    private void insertNode(Node n) {
        DLL dll;
        if (freqMap.containsKey(n.freq)) {
            dll = freqMap.get(n.freq);
        } else {
            dll = new DLL();
        }
        n.next = dll.head.next;
        dll.head.next.prev = n;
        dll.head.next = n;
        n.prev = dll.head;
        freqMap.put(n.freq, dll);
    }
    
    private void deleteNode(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        emptyDLLCheckAfterDelete(n);
    }
    
    private void emptyDLLCheckAfterDelete(Node n) {
        DLL dll = freqMap.get(n.freq);
        if (dll.head.next == dll.tail && dll.tail.prev == dll.head) {
            freqMap.remove(n.freq);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */