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
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        return reverse(head, null);
    }
    public ListNode reverse(ListNode curr, ListNode prev)
    {
        if(curr == null)
            return prev;
        //curr = 0, next = 1 -> 2 -> 3, prev = null, 0 -> null 
        //curr = 1, next = 2 -> 3, prev = 0, 1 -> 0 -> null;
        //curr = 2, next = 3 -> null, prev = 2, 2 -> 1 -> 0 -> null;
        //curr = 3, next = null, prev = 3, 3 -> 2 -> 1 -> 0 -> null
        ListNode next = curr.next;
        curr.next = prev;
        return reverse(next, curr);
    }
}
