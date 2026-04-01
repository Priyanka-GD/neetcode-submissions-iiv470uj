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
    int preorderIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int idx = 0; idx < inorder.length; idx++){
            inorderMap.put(inorder[idx], idx);
        }
        return buildingTree(0, preorder.length - 1, preorder, inorderMap);
    }

    public TreeNode buildingTree(int left, int right, int[] preorder, Map<Integer, Integer> inorderMap){
        if(left > right){
            return null;
        }
        int rootVal = preorder[preorderIdx++];
        int idx = inorderMap.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        node.left = buildingTree(left, idx - 1, preorder, inorderMap);
        node.right = buildingTree(idx + 1, right, preorder, inorderMap);
        return node;
    }
}
