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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap=new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }
      return buildTree(inorder,postorder,0,inorder.length-1, 0,postorder.length-1,inMap)  ;
    }
     public TreeNode buildTree(int[] inorder, int[] postorder, int is, int ie, int ps, int pe, Map<Integer, Integer> inMap){

if(is>ie || ps>pe)return null;

    TreeNode root = new TreeNode(postorder[pe]);
    int inRoot = inMap.get(root.val);
    int numsleft = inRoot - is;
    root.left= buildTree(inorder,postorder,is,inRoot-1, ps,ps+numsleft-1, inMap);
    root.right = buildTree(inorder,postorder,inRoot+1,ie, ps+numsleft,pe-1,inMap);
return root;

     }

}