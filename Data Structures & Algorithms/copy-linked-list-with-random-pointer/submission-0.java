/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> cloneNodeMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        return getClonedNodes(head);
    }
    private Node getClonedNodes(Node node){
        if(node == null)
            return null;
        
        if(cloneNodeMap.containsKey(node))
            return cloneNodeMap.get(node);
        
        Node newNode = new Node(node.val);
        cloneNodeMap.put(node, newNode);
        
        newNode.next = getClonedNodes(node.next);
        newNode.random = getClonedNodes(node.random);
        return newNode;  
    }
}
