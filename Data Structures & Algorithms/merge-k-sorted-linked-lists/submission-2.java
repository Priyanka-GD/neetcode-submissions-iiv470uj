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
        PriorityQueue<ListNode> newList = new PriorityQueue<>((a, b) -> Integer.compare(a.val , b.val));
        for(ListNode list : lists){
            if(list != null){
                newList.add(list);
            }
        }
        ListNode head = null, curr = null;
        while(!newList.isEmpty()){
            if(head == null){
                head = newList.poll();
                curr = head;
            }else{
                curr.next = newList.poll();
                curr = curr.next;
            }
            if(curr.next != null){
                newList.add(curr.next);
            }
        }
        return head;
    }
}
