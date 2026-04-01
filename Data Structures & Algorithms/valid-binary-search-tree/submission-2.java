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

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return isBSTValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
    private boolean isBSTValid(TreeNode node, int min, int max){
        if(node == null)
            return true;
        else if(min >= node.val)
            return false;
        else if(max <= node.val)
            return false;
        return isBSTValid(node.left, min, node.val) && isBSTValid(node.right, node.val, max);
    }
}
