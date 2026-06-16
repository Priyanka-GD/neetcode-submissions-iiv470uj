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
        StringBuilder serializedStr = new StringBuilder();
        inorderTraversal(root, serializedStr);
        return serializedStr.toString();  
    }

    public void inorderTraversal(TreeNode node, StringBuilder str){
        if(node == null){
            str.append("null").append("#");
            return;
        }
        str.append(node.val).append("#");
        inorderTraversal(node.left, str);
        inorderTraversal(node.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String nodes[] = data.split("#");
        int[] nodeIdx = new int[1];
        return deserializedTree(nodes, nodeIdx);
    }

    public TreeNode deserializedTree(String[] nodes, int[] nodeIdx){
        int idx = nodeIdx[0];
        if(nodes[idx].equals("null") || idx >= nodes.length){
            nodeIdx[0]++;
            return null;
        }
        int nodeVal = Integer.parseInt(nodes[idx]);
        TreeNode node = new TreeNode(nodeVal);
        nodeIdx[0]++;
        node.left = deserializedTree(nodes, nodeIdx);
        node.right = deserializedTree(nodes, nodeIdx);
        return node;
    }


}
