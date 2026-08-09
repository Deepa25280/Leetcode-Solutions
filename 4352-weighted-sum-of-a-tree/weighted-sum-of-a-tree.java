class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n=parent.length;
        List<Integer>[] li=new ArrayList[n];
        for(int i=0; i<n; i++){
            li[i] = new ArrayList<>();
        }
        for(int i=1; i<n; i++){
            li[parent[i]].add(i);
        }
        int[] dt=new int[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int ht=1;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int c:li[node]){
                dt[c]=dt[node]+1;
                ht=Math.max(ht, dt[c]+1);
                q.add(c);
            }
        }
        long res=0;
        for(int i=0; i<n; i++){
            long wt=(long)nums[i]*(ht-dt[i]);
            res+=wt;
        }
        return res;
    }
}