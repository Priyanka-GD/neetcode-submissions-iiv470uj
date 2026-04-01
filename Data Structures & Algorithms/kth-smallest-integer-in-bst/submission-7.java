class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // Use an array to hold state; each call gets its own array instance
        int[] result = new int[1]; 
        int[] counter = new int[1];
        traverse(root, k, counter, result);
        return result[0];
    }

    private void traverse(TreeNode node, int k, int[] counter, int[] result) {
        if (node == null || counter[0] >= k)
            return;

        traverse(node.left, k, counter, result);

        counter[0]++;
        if (counter[0] == k) {
            result[0] = node.val;
            return;
        }

        traverse(node.right, k, counter, result);
    }
}