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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        int currDia = lh+rh;
        int lDia = diameterOfBinaryTree(root.left);
        int rDia = diameterOfBinaryTree(root.right);

        return Math.max(currDia, Math.max(lDia, rDia));
        
    }
    public int height(TreeNode root) {
        if(root==null)return 0;
     
      int x = height(root.left);
      int y = height(root.right);
      return 1+Math.max(x,y);
    }
}