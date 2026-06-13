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
        ListNode curr = head, prev = null;
        return reverseHead(curr, prev);
    }

    public ListNode reverseHead(ListNode curr, ListNode prev){
        if(curr == null){
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        return reverseHead(next, curr);
    }
}
// O(n) where n is the number of nodes  - TC and SC is O(1)
