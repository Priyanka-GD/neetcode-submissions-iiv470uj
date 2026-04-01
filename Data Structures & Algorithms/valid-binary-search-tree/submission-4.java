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
        return validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean validBST(TreeNode node, int min, int max){
        if(node == null)
            return true;
        if(min >= node.val)
            return false;
        if(max <= node.val)
            return false;
        return validBST(node.left, min, node.val) && validBST(node.right, node.val, max);
    }
}
