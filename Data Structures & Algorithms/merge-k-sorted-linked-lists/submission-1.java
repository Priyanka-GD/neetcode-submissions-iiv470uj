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
    public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap 
        = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));       
        for(ListNode list : lists){
            if(list != null){
                minHeap.add(list);
            }
        }
        ListNode head = null, curr = null;

        while(!minHeap.isEmpty()){
            ListNode currNode = minHeap.poll();
            if(head == null){
                head = currNode;
                curr = head;
            } else {
                curr.next = currNode;
                curr = curr.next;

            }
            if(curr.next != null){
                minHeap.add(curr.next);
            }
        }
        return head;
    }
}
