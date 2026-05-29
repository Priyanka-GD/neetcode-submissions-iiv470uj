class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            updateNode(node);
            return node.value;
        }
        return -1;
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void updateNode(Node node){
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        node.prev = head;
        headNext.prev = node;
    }

    public void put(int key, int value) {
        if(map.size() == capacity && !map.containsKey(key)){
            Node node = tail.prev;
            removeNode(node);
            map.remove(node.key);
        }
        if(!map.containsKey(key)){
            Node node = new Node(key ,value);
            updateNode(node);
            map.put(key, node);
        }else {
            Node node = map.get(key);
            removeNode(node);
            node.value = value;
            updateNode(node);
        }
    }
}
class Node{
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
