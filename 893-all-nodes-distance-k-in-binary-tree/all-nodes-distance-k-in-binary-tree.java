/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void mark_parent(TreeNode root, Map<TreeNode, TreeNode> parent_track){
Queue<TreeNode> q = new LinkedList<>();
q.offer(root);
while(!q.isEmpty()){
     TreeNode curr = q.poll();
     if(curr.left!=null){
     parent_track.put(curr.left, curr);
     q.offer(curr.left);
   }
     if(curr.right!=null){
     parent_track.put(curr.right, curr);
     q.offer(curr.right);
   }
}
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>(); 
        Map<TreeNode, Boolean> vis = new HashMap<>();
        mark_parent(root, parent_track);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.put(target, true);
        int currlevel=0;
        while(!q.isEmpty()){
            int size = q.size();
            if(currlevel==k)break;
            currlevel++;
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && vis.get(curr.left)==null){
                    vis.put(curr.left, true);
                    q.offer(curr.left);
                }
                if(curr.right!=null && vis.get(curr.right)==null){
                   vis.put(curr.right, true);
                    q.offer(curr.right);
                }
                if(parent_track.get(curr)!=null && vis.get(parent_track.get(curr))==null){
                    q.offer(parent_track.get(curr));
                    vis.put(parent_track.get(curr), true);
                }
            }
        }
       List<Integer> ans= new ArrayList<>();
       while(!q.isEmpty()){
        ans.add(q.poll().val);
       } 
        return ans;
    }
   
}