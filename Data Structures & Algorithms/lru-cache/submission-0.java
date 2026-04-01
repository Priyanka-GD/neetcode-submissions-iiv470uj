class LRUCache {
    Map<Integer, ListNode> cacheMap;
    ListNode head;
    ListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.cacheMap = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void updateNodePositionInList(ListNode toUpdate) {
        ListNode currNext = head.next;
        head.next = toUpdate;
        toUpdate.prev = head;
        toUpdate.next = currNext;
        currNext.prev = toUpdate;
    }

    private void removeNode(ListNode toRemove) {
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            ListNode node = cacheMap.get(key);
            removeNode(node);
            updateNodePositionInList(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            ListNode node = cacheMap.get(key);
            removeNode(node);
        }
        ListNode newNode = new ListNode(key, value);
        updateNodePositionInList(newNode);
        cacheMap.put(key, newNode);
        if (cacheMap.size() > capacity) {
            ListNode toRemove = tail.prev;
            removeNode(toRemove);
            cacheMap.remove(toRemove.key);
        }
    }
}

class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.value = val;
    }
}