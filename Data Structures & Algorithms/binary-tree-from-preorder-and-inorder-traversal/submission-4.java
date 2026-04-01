class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map is local to the method, so it's thread-safe
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int idx = 0; idx < inorder.length; idx++) {
            inorderMap.put(inorder[idx], idx);
        }

        // Pass the index as a reference in a 1-element array
        // Each thread that calls buildTree() gets its own 'pIdx' array on its stack
        int[] pIdx = new int[]{0}; 
        
        return buildingTree(0, preorder.length - 1, preorder, inorderMap, pIdx);
    }

    private TreeNode buildingTree(int left, int right, int[] preorder, Map<Integer, Integer> inorderMap, int[] pIdx) {
        if (left > right) {
            return null;
        }

        // Access and increment the value inside the array
        int rootVal = preorder[pIdx[0]];
        pIdx[0]++; 
        
        int idx = inorderMap.get(rootVal);
        TreeNode node = new TreeNode(rootVal);

        // Pass the same pIdx array down; it persists the counter for THIS thread only
        node.left = buildingTree(left, idx - 1, preorder, inorderMap, pIdx);
        node.right = buildingTree(idx + 1, right, preorder, inorderMap, pIdx);
        
        return node;
    }
}