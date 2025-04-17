class Node {
    int key;
    int val;
    int freq;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
        this.next = null;
        this.prev = null;
    }
}

class LRU {
    Node head;
    Node tail;
    int size;

    LRU() {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    void addFirst(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        size++;
    }

    Node removeLast() {
        Node removedNode = tail.prev;
        removeNode(removedNode);
        return removedNode;
    }

    void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
    }
}

class LFUCache {

    int minFreq;
    int cap;
    int size;
    Map<Integer, Node> map;
    Map<Integer, LRU> freq;

    public LFUCache(int capacity) {
        this.minFreq = 0;
        this.cap = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.freq = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        updateFreq(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            updateFreq(node);
            return;
        }
        if (size == cap) {
            //Remove from min freq
            LRU minLRU = freq.get(minFreq);
            Node removedNode = minLRU.removeLast();
            map.remove(removedNode.key);
            size--;          
        }
        //add new node
        Node newNode = new Node(key, value);
        minFreq = 1;
        LRU minLRU = freq.getOrDefault(minFreq, new LRU());
        minLRU.addFirst(newNode);
        freq.put(minFreq, minLRU);
        map.put(key, newNode);
        size++;
    }

    private void updateFreq(Node node) {
        LRU lru = freq.get(node.freq);
        lru.removeNode(node);

        if (lru.size == 0 && minFreq == node.freq) {
            minFreq++;
        }
        node.freq++;

        lru = freq.getOrDefault(node.freq, new LRU());
        lru.addFirst(node);
        freq.put(node.freq, lru);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */