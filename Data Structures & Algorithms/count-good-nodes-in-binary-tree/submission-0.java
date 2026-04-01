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
    int goodNodesCount = 0;
    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;
        countGoodNodes(root, root.val);
        return goodNodesCount;
    }

    public void countGoodNodes(TreeNode node, int maxVal) {
        if (node != null && node.val >= maxVal)
            goodNodesCount++;

        if (node.left != null) {
            countGoodNodes(node.left, Math.max(maxVal, node.left.val));
        }
        if (node.right != null) {
            countGoodNodes(node.right, Math.max(maxVal, node.right.val));
        }
    }
}
