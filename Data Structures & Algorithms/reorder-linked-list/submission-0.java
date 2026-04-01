class Solution {
    public void reorderList(ListNode head) {
        //Find the middle of the linked list
        // 1->2->3->4->5->6
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow = 4->5->6
        ListNode curr = slow;
        //reversed node from slow is stored in prev
        ListNode prev = null;
        while(curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //prev  = 6->5->4
        //head = 1->2->3->4
        ListNode first = head, second = prev;
        //first = 1->2->3->4
        //second = 6->5->4
        while(second.next != null)
        {
            ListNode temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }

    }
}
