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
       int[][] vis = new int[m][n];
       for(int i=0; i<m; i++){
          if(vis[i][0]==0 && board[i][0]=='O'){
            dfs(i, 0, vis, board, dr, dc);
          }
          if(vis[i][n-1]==0 && board[i][n-1]=='O'){
            dfs(i, n-1, vis, board, dr, dc);
          }
       } 
       for(int j=0; j<n; j++){
        if(vis[0][j]==0 && board[0][j]=='O'){
            dfs(0, j, vis, board, dr, dc);
        }
        if(vis[m-1][j]==0 && board[m-1][j]=='O'){
            dfs(m-1, j, vis, board, dr, dc);
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
    private void dfs(int row, int col,int[][] vis,char[][] board, int[]dr, int[] dc){
        vis[row][col]=1;
            int m=board.length;
       int n=board[0].length;
        for(int i=0; i<4; i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]=='O' && vis[nr][nc]==0){
                dfs(nr, nc,  vis,board, dr, dc);
            }
        }
    }
}