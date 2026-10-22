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
    public boolean isBalanced(TreeNode root) {
        if(checkHeight(root)==-1)return false;
        else return true;
    }
    public int checkHeight(TreeNode root){
        if(root==null)return 0;
        int leftht = checkHeight(root.left);
        if(leftht==-1)return -1;
        int rightht = checkHeight(root.right);
        if(rightht==-1)return -1; 
        if(Math.abs(leftht-rightht)>1)return -1;
        return 1+Math.max(leftht, rightht);
    }
}