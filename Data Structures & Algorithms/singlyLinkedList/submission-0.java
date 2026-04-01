class LinkedList {
    ListNode head;
    ListNode tail;
    public LinkedList() {
        head = new ListNode(-1);
        tail = head;
    }

    public int get(int index) {
        ListNode curr = head.next;
        int idx = 0;
        while(curr != null){
            if(idx == index){
                return curr.val;
            }
            idx++;
            curr = curr.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        if(newNode.next == null){
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
    }

    public boolean remove(int index) {
        int idx = 0;
        ListNode curr = head;
        while(idx < index && curr != null){
            idx++;
            curr = curr.next;
        }
        if (curr != null && curr.next != null) {
            if (curr.next == tail) {
                tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode curr = head.next;
        while (curr != null) {
            res.add(curr.val);
            curr = curr.next;
        }
        return res;
    }
}
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }
