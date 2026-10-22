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
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int values:preorder){
            root = insert(root, values);
        }
        return root;
    }
    public TreeNode insert(TreeNode root, int values) {
        if(root == null){
            return new TreeNode(values);
        }
        if(root.val>values){
            root.left = insert(root.left,values);
        }
        else if(root.val<values){
            root.right = insert(root.right,values);
        }
        return root;
    }
}