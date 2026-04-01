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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = { 0 };
        getLengthOfTheTree(root, diameter);
        return diameter[0];
    }

    private int getLengthOfTheTree(TreeNode node, int[] diameter){
        if(node == null)
            return 0;
        int leftHt = getLengthOfTheTree(node.left, diameter);
        int rightHt = getLengthOfTheTree(node.right, diameter);

        diameter[0] = Math.max(leftHt + rightHt, diameter[0]);
        return Math.max(leftHt, rightHt) + 1;
    }
}
