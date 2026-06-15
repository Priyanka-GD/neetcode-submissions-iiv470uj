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
    public int kthSmallest(TreeNode root, int k) {
        int result[] = new int[1];
        int count[] = new int[1];
        countKthSmallest(root, k, result, count);
        return result[0];
    }

    public void countKthSmallest(TreeNode node, int k, int[] result, int[] count){
        if(node == null)
            return;
        countKthSmallest(node.left, k, result, count);
        count[0]++;
        if(count[0] == k){
            result[0] = node.val;
            return;
        }
        countKthSmallest(node.right, k, result, count);
    }
}
