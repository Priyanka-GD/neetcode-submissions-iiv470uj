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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        gainFromNode(root);
        return maxSum;
    }

    private int gainFromNode(TreeNode node) {
        if (node == null) return 0;

        // 1. Get max gain from left and right subtrees
        // Use Math.max(0, ...) to ignore paths with negative sums
        int leftGain = Math.max(gainFromNode(node.left), 0);
        int rightGain = Math.max(gainFromNode(node.right), 0);

        // 2. The price of the path passing through this node (the "bend")
        int currentPathSum = node.val + leftGain + rightGain;

        // 3. Update global maximum
        maxSum = Math.max(maxSum, currentPathSum);

        // 4. Return the maximum gain this node can offer to its parent
        // (Either the left path or the right path, but not both!)
        return node.val + Math.max(leftGain, rightGain);
    }
}

