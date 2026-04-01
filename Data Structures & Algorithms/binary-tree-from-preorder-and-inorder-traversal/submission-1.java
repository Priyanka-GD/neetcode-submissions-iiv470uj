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
        return buildTreeFromNodes(0, preorder.length - 1, preorder, inorderMap);
    }
    private TreeNode buildTreeFromNodes(int startIdx, int endIdx, int[] preorder, Map<Integer, Integer> inorderMap){
        if(startIdx > endIdx)
            return null;
        int rootVal = preorder[preorderIdx++];
        int rootIdx = inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeFromNodes(startIdx, rootIdx - 1, preorder, inorderMap);
        root.right = buildTreeFromNodes(rootIdx + 1, endIdx, preorder, inorderMap);
        return root;
    }
}
