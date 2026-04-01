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
    //List<Integer> nodeValues = new ArrayList<>();
    int countOfNodes = 0, result = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        inOrderTraversal(root, k);
        return result;
    }
    private void inOrderTraversal(TreeNode node, int k){
        if(node.left != null)
            inOrderTraversal(node.left, k);
        if(node != null){
            countOfNodes++;
            if(countOfNodes == k){
                result = node.val;
                return;
            }     
        }
        if(node.right != null)
            inOrderTraversal(node.right, k);
    }
}
