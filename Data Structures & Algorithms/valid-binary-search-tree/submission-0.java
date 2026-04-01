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
        return checkValidBST(root, null, null);
    }
    private boolean checkValidBST(TreeNode node, Integer minVal, Integer maxVal)
    {
        if(node == null)
            return true;
        if(minVal != null && node.val <= minVal)
            return false;
        if(maxVal != null && node.val >= maxVal)
            return false;
        return checkValidBST(node.left, minVal, node.val) && 
            checkValidBST(node.right, node.val, maxVal); 
    }
}
