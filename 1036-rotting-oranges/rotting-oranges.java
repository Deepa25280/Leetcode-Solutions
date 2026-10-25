class Solution {
    public class Pair{
        int r; int c; int t;
        Pair(int r, int c, int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        return bfs(grid, q, fresh);
    }
    private int bfs(int[][] grid,Queue<Pair> q,int fresh){
        int time=0;
        int m=grid.length;
        int n=grid[0].length;
        int[] delr={-1,0,1,0};
        int[] delc = {0,-1,0,1};
        while(!q.isEmpty()){
            Pair p = q.poll();
     
            time=Math.max(time, p.t);
            for(int i=0; i<4; i++){
                int nr=p.r+delr[i];
                int nc=p.c+delc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    fresh--;
                    q.offer(new Pair(nr,nc,p.t+1));
                }
            }

        }
        return fresh==0?time:-1;
    }
}