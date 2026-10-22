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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> li = new ArrayList<>();
        li=inorder(root);
        return li.get(k-1);
       
    }
    public List<Integer> inorder(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        if(root == null){
         return li;
        }
        li.addAll(inorder(root.left));
        li.add(root.val);
        li.addAll(inorder(root.right));
        return li;
    }
}