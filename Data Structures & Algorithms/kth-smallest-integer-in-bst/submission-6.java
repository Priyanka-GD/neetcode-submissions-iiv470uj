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
    int countNodes = 0, resultNodeVal = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        computeKthSmallest(root, k);
        return resultNodeVal;
    }

    public void computeKthSmallest(TreeNode node, int k){
        if(node == null)
            return;
        computeKthSmallest(node.left, k);
        if(node != null){
            countNodes++;
            if(countNodes == k){
                resultNodeVal = node.val;
                return;
            }
        }
        if(countNodes < k){
            computeKthSmallest(node.right, k);
        }
    }
}
/*
Persisting State Across Recursion
If you were to define countNodes inside the computeKthSmallest method, 
it would reset to 0 every time the function calls itself.

Time O(H + k) You traverse the height to reach the start, 
then visit knodes.

Space O(H) This is the maximum depth of the recursive call stack.
*/
