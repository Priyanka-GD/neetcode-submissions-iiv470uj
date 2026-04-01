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
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondPart = reverseNode(slow.next , null);
        slow.next = null;
        ListNode firstPart = head;

        while(firstPart != null && secondPart != null){
            ListNode firstNext = firstPart.next;
            firstPart.next = secondPart;
            
            firstPart = firstPart.next;

            secondPart = secondPart.next;
            firstPart.next = firstNext;
            firstPart = firstPart.next;
            
        }
        // 2->8
        //4 
        // 6



    }

    public ListNode reverseNode(ListNode curr, ListNode prev){
        if(curr == null)
            return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return reverseNode(next, curr);
    }
}
