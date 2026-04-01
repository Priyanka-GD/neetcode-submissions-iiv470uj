class Solution {
    int countGoodNodes = 0;
    public int goodNodes(TreeNode root) {
        if(root == null)
            return 0;
        getGoodNodeCount(root, root.val);
        return this.countGoodNodes;
    }

    private void getGoodNodeCount(TreeNode node, int maxSoFar){
        if(node == null)
            return;
        if(maxSoFar <= node.val){
            maxSoFar = node.val;
            this.countGoodNodes++;
        }
        if(node.left != null)
            getGoodNodeCount(node.left, maxSoFar);
        if(node.right != null)
            getGoodNodeCount(node.right, maxSoFar);
    }
}
