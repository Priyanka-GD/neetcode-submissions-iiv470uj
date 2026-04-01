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
        StringBuilder string = new StringBuilder();
        preorderTraversal(root, string);
        return string.toString();
    }
    private void preorderTraversal(TreeNode node, StringBuilder string){
        if(node == null){
            string.append("null->");
            return;
        }
        string.append(node.val + "->");
        preorderTraversal(node.left, string);
        preorderTraversal(node.right, string);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        String nodes[] = data.split("->");
        int idx[] ={0};
        return populateChildren(nodes, idx);
    }

    private TreeNode populateChildren(String[] nodes, int[] idx){
        if(idx[0] >= nodes.length || nodes[idx[0]].equals("null")){
            idx[0]++;
            return null;
        }
        int nodeVal = Integer.parseInt(nodes[idx[0]]);
        TreeNode root = new TreeNode(nodeVal);
        idx[0]++;
        root.left = populateChildren(nodes, idx);
        root.right = populateChildren(nodes, idx);
        return root;
    }
}
