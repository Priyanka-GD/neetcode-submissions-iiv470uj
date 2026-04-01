/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode start = head, fast = head;
        while(fast != null && fast.next != null){
            start = start.next;
            fast = fast.next.next;
            if(start == fast)
                return true;
        }
        return false;
    }
}
