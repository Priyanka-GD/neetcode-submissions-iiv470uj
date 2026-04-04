class LinkedList {
    Node head, tail;
    int size;
    public LinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        Node temp = head.next;
        for(int idx = 0; idx < index; idx++){
            temp = temp.next;
        }
        return temp.key;
    }

    public void insertHead(int val) {
        addAtIndex(0, val);
    }

    public void insertTail(int val) {
        addAtIndex(size, val);
    }

    public boolean remove(int index) {
        if(index < 0 || index >= size){
            return false;
        }
        Node pred = head;
        for(int idx = 0; idx < index; idx++){
            pred = pred.next;
        }
        Node succ = pred.next.next;
        pred.next = succ;
        succ.prev = pred;
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> result = new ArrayList<>();
        Node temp = head.next;
        while(temp != tail){
            result.add(temp.key);
            temp = temp.next;
        }
        return result;
    }

    public void addAtIndex(int index, int val){
        if(index < 0 || index > size){
            return;
        }
        Node pred = head;
        for(int idx = 0; idx < index; idx++){
            pred = pred.next;
        }

        Node succ = pred.next;

        Node newNode = new Node(val);

        newNode.prev = pred;
        newNode.next = succ;
        pred.next = newNode;
        succ.prev = newNode;
        size++;
    }
}
class Node{
    int key;
    Node next;
    Node prev;

    public Node(int key){
        this.key = key;
    }
}
