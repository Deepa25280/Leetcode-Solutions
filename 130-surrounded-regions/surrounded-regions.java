class Solution {
    class Pair{
        int r; int c;
        Pair(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    public void solve(char[][] board) {
       int m=board.length;
       int n=board[0].length;
   int[] dr = {-1,0,1,0};
   int[] dc ={0,-1,0,1};
   Queue<Pair> q =new LinkedList<>();
       int[][] vis = new int[m][n];
       for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if((i==0 || j==0||j==n-1||i==m-1) && board[i][j]=='O' && vis[i][j]==0){
                q.offer(new Pair(i, j));
                vis[i][j]=1;
            }
        }
       }
       while(!q.isEmpty()){
        Pair p = q.poll();
        int r=p.r; int c=p.c;
        for(int i=0; i<4; i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]=='O'&& vis[nr][nc]==0){
                  q.offer(new Pair(nr, nc));
                  vis[nr][nc]=1;
            }
        }
       }
       
       for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(board[i][j]=='O' && vis[i][j]==0){
                board[i][j]='X';
            }
        }
       }
   
    }
}