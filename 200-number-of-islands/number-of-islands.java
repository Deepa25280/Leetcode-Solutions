class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis = new int[n][m];
        int cnt =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    bfs(i, j, grid, vis);
                }
            }
        }
        return cnt;
    }
    public void bfs(int r, int c, char[][] grid, int[][] vis){
        
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        vis[r][c] = 1;
 
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int curr[] = q.remove();
            int row = curr[0];
            int col = curr[1];

            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                vis[nrow][ncol] = 1;
                    q.add(new int[] { nrow, ncol});
                     
                }
            }
        }
       
    }
}