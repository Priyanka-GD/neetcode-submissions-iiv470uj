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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getLengthOfTheTree(root);
        return diameter;
    }

    private int getLengthOfTheTree(TreeNode node){
        if(node == null)
            return 0;
        int leftHt = getLengthOfTheTree(node.left);
        int rightHt = getLengthOfTheTree(node.right);

        diameter = Math.max(leftHt + rightHt, diameter);
        return Math.max(leftHt, rightHt) + 1;
    }
}
