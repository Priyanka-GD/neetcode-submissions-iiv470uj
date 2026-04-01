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
            maxValSoFar = node.val;
            goodNodesCount++;
        }
        if(node.left != null)
            checkForGoodNodes(node.left, maxValSoFar);
        if(node.right != null)
            checkForGoodNodes(node.right, maxValSoFar);
    }

}