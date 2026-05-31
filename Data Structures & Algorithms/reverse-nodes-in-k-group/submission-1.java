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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        while(curr != null && count < k){
            curr = curr.next;
            count++;
        }
        if(count == k){
            ListNode reversedNode = reverseList(head, k);
            head.next = reverseKGroup(curr, k);
            return reversedNode;
        }
        return head;
    }

    public ListNode reverseList(ListNode node, int k){
        ListNode prev = null;
        ListNode curr = node;

        while(k > 0){
            ListNode nextNode = curr.next; //
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            k--;
        }

        return prev;
    }
}
