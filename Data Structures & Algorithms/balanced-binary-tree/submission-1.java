class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int heightLeft = getHeight(root.left);
        int heightRight = getHeight(root.right);
        if (Math.abs(heightLeft - heightRight) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.left),
                getHeight(node.right));
    }
}
