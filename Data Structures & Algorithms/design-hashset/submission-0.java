class MyHashSet {
    Bucket[] buckets;

    public MyHashSet() {
        buckets = new Bucket[1000];
        for (int idx = 0; idx < 1000; idx++) {
            buckets[idx] = new Bucket();
        }
    }

    public void add(int key) {
        int hash = getHash(key);
        buckets[hash].addNode(key);
    }

    public void remove(int key) {
        int hash = getHash(key);
        buckets[hash].removeNode(key);
    }

    public boolean contains(int key) {
        int hash = getHash(key);
        return buckets[hash].containsNode(key);
    }

    public int getHash(int key) {
        return key % 1000;
    }
}

class Bucket {
    Node head;

    public Bucket() {
        head = new Node(-1);
    }

    public void addNode(int val) {
        if (!containsNode(val)) {
            Node node = new Node(val);
            Node next = head.next;
            head.next = node;
            node.next = next;
        }
    }

    public boolean containsNode(int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.key == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void removeNode(int val) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.key == val) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
}

class Node {
    int key;
    Node next;

    public Node(int key) {
        this.key = key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */