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

    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        getPreOrderTraversal(root, str);
        return str.toString();
    }
    public void getPreOrderTraversal(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("null->");
            return;
        }
        str.append(root.val + "->");
        getPreOrderTraversal(root.left, str);
        getPreOrderTraversal(root.right, str);
    }
    public TreeNode deserialize(String data) {
        String nodes[] = data.split("->");
        int nodeIdx[] = new int[1];
        return deserializeTree(nodes, nodeIdx);
    }

    public TreeNode deserializeTree(String nodes[], int nodeIdx[]){
        if(nodes[nodeIdx[0]].equals("null") || nodeIdx[0] >= nodes.length){
            nodeIdx[0]++;
            return null;
        }
        int nodeVal = Integer.parseInt(nodes[nodeIdx[0]]);
        TreeNode root = new TreeNode(nodeVal);
        nodeIdx[0]++;
        root.left = deserializeTree(nodes, nodeIdx);
        root.right = deserializeTree(nodes, nodeIdx);
        return root;
    }
}
