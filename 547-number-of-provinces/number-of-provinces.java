class Solution {
    private void dfs(int[][] isConnected,int[] vis, int i){
        vis[i]=1;
        for(int j=0; j<isConnected.length; j++){
            if(isConnected[i][j]==1 && vis[j]!=1){
                dfs(isConnected, vis, j);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int m=isConnected.length;
        int[] vis = new int[m];
        int cnt=0;
        for(int i=0; i<m; i++){
           if(vis[i]!=1){
            cnt++;
            dfs(isConnected, vis, i);
            
           }
        }
        return cnt;
    }
}