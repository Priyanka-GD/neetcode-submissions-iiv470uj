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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        ListNode resultNode = new ListNode(-1);
        resultNode.next = head;
        curr = resultNode;
        int idx = 0;
        while (curr != null) {
            idx++;
            if (idx  == length - n + 1)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return resultNode.next;
    }
}
