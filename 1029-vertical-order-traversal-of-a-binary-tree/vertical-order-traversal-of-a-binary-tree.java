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
 class Tuple{
    TreeNode node;
    int col; 
    int row;
    Tuple(TreeNode node, int col, int row){
        this.node = node;
        this.col = col;
        this.row = row;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
          List<List<Integer>> ans = new ArrayList<>();
       TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
       if (root == null) {
            return ans;
        }
       Queue<Tuple> q = new LinkedList<>();
       q.add(new Tuple(root, 0, 0));
       while(!q.isEmpty()){
        Tuple tuple = q.poll();
         TreeNode node = tuple.node;
         int col = tuple.col;
         int row = tuple.row;
         if(!map.containsKey(col)){
            map.put(col, new TreeMap<>());
         }
         if(!map.get(col).containsKey(row)){
            map.get(col).put(row, new PriorityQueue<>());
         }
         map.get(col).get(row).offer(node.val);
          if(node.left!=null){
             q.offer(new Tuple(node.left, col-1, row+1));
           }
           if(node.right!=null){
            q.offer(new Tuple(node.right, col+1, row+1));
           }
        } 
       for(TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()){
          List<Integer> column = new ArrayList<>();
          for(PriorityQueue<Integer> nodes:rows.values()){
          while (!nodes.isEmpty()) {
             column.add(nodes.poll());
          }
          }
          ans.add(column);
       }
       return ans;
    }
}