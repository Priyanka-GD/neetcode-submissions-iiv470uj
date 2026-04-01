class Solution {
    int goodNodesCount = 0;
    public int goodNodes(TreeNode root) {
        checkForGoodNodes(root, root.val);
        return goodNodesCount;
    }
    private void checkForGoodNodes(TreeNode node, int maxValSoFar){
        if(node == null)
            return;
        
        if(node.val >= maxValSoFar){
            goodNodesCount++;
        }
        if(node.left != null)
            checkForGoodNodes(node.left, Math.max(maxValSoFar, node.left.val));
        if(node.right != null)
            checkForGoodNodes(node.right, Math.max(maxValSoFar, node.right.val));
    }

}
