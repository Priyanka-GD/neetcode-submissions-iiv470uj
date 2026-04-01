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

public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        preOrderTraversal(root, str);
        return str.toString();
    }

    public void preOrderTraversal(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("null").append("#");
            return;
        }
        str.append(root.val).append("#");
        preOrderTraversal(root.left, str);
        preOrderTraversal(root.right, str);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String nodes[] = data.split("#");
        int nodeIdx[] = new int[1];
        return deserializeTree(nodes, nodeIdx);
    }

    public TreeNode deserializeTree(String[] nodes, int[] nodeIdx){
        int idx = nodeIdx[0];
        if(nodes[idx].equals("null") || idx >= nodes.length){
            nodeIdx[0]++;
            return null;
        }

        int nodeVal = Integer.parseInt(nodes[idx]);
        TreeNode node = new TreeNode(nodeVal);
        nodeIdx[0]++;
        node.left = deserializeTree(nodes, nodeIdx);
        node.right = deserializeTree(nodes, nodeIdx);
        return node;
    }
}
