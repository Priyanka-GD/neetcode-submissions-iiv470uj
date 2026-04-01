/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// If I count nodes - starting left tree Nodes, then if at any point k == count of nodes then we can return the value
class Solution {
    List<Integer> nodeValues = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        inOrderTraversal(root);
        return nodeValues.get(k - 1);
    }
    private void inOrderTraversal(TreeNode node){
        if(node.left != null)
            inOrderTraversal(node.left);
        if(node != null)
            nodeValues.add(node.val);
        if(node.right != null)
            inOrderTraversal(node.right);
    }
}
