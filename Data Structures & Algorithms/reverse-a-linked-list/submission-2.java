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
        ListNode prev = reverseNode(head, null);
        return prev;
    }

    public ListNode reverseNode(ListNode curr, ListNode prev){
        if(curr == null)
            return prev;
        ListNode next = curr.next;
        curr.next = prev; 
        return reverseNode(next, curr);
    }
}
