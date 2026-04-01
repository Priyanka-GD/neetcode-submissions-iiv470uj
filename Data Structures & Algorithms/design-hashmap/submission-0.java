class MyHashMap {
    private final int BUCKET_COUNT = 1000;
    Bucket buckets[];

    public MyHashMap() {
        buckets = new Bucket[BUCKET_COUNT];
        for (int bucketIdx = 0; bucketIdx < BUCKET_COUNT; bucketIdx++) {
            buckets[bucketIdx] = new Bucket();
        }
    }

    public int getHashCode(int key) {
        return key % BUCKET_COUNT;
    }

    public void put(int key, int value) {
        int idx = getHashCode(key);
        buckets[idx].put(key, value);
    }

    public int get(int key) {
        int idx = getHashCode(key);
        return buckets[idx].get(key);
    }

    public void remove(int key) {
        int idx = getHashCode(key);
        buckets[idx].remove(key);
    }
}

class Bucket {
    Node node;

    public Bucket() {
        node = new Node(-1, -1);
    }

    public boolean containsKey(int key) {
        Node curr = node;
        while (curr.next != null) {
            if (curr.next.key == key)
                return true;
            curr = curr.next;
        }
        return false;
    }

    public void put(int key, int value) {
        if (containsKey(key)) {
            remove(key);
        }
        Node newNode = new Node(key, value);
        newNode.next = node.next;
        node.next = newNode;
    }

    public void remove(int key) {
        Node curr = node;
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public int get(int key) {
        Node curr = node;
        while (curr.next != null) {
            if (curr.next.key == key)
                return curr.next.value;
            curr = curr.next;
        }
        return -1;
    }
}

class Node {
    int key;
    int value;
    Node next = null;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */