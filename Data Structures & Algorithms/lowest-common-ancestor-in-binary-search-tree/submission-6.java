class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            // If both p and q are greater than curr, LCA must be in the right subtree
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } 
            // If both p and q are smaller than curr, LCA must be in the left subtree
            else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } 
            // If one is smaller and one is larger (or one equals curr), 
            // we have found the split point. This is the LCA.
            else {
                return curr;
            }
        }
        return null;
    }
}