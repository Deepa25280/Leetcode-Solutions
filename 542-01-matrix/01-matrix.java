class Solution {
    class Pair{
        int r; int c; int d;
        Pair(int r, int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] vis = new int[m][n];
        int[][] dis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0 && vis[i][j]==0){
                   q.offer(new Pair(i, j, 0));
                   vis[i][j]=1;
                }
            }
        }
        int[] delr = {-1,0, 1, 0};
        int[] delc = {0,-1,0,1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int d=p.d;
            dis[r][c]=d;
            for(int i=0; i<4; i++){
                int nr=r+delr[i];
                int nc=c+delc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==1 && vis[nr][nc]==0){
                    q.offer(new Pair(nr, nc, p.d+1));
                    vis[nr][nc]=1;
                }
            }
        }
        return dis;
    }
}