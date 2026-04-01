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
//Preorder - root, left, right
//Inorder - left, root, right
class Solution {
    int preorderIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> rootWithIdx = new HashMap<>();
        int idx = 0;
        for(int node : inorder){
            rootWithIdx.put(node, idx++);
        }
        return traverseTree(preorder, rootWithIdx, 0, inorder.length - 1);
    }
    private TreeNode traverseTree(int[] preorder, Map<Integer, Integer> rootWithIdx, int left, int right)
    {
        if(left > right)
            return null;
        int rootVal =  preorder[preorderIdx++];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = rootWithIdx.get(rootVal);
        root.left = traverseTree(preorder, rootWithIdx, left, rootIdx - 1);
        root.right = traverseTree(preorder, rootWithIdx, rootIdx + 1, right);
        return root;
    }
}
