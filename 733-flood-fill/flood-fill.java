class Solution {
    public void dfs(int[][] image,int[][] ans,int sr, int sc,int newcolor, int iniCol,int[] delr,int[] delc){
    ans[sr][sc]=newcolor;
    int m = image.length;
    int n = image[0].length;
    for(int i=0; i<4; i++){
        int nr = sr+delr[i];
        int nc = sc+delc[i];
        if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==iniCol && ans[nr][nc]!=newcolor){
          dfs(image,ans,nr, nc, newcolor, iniCol, delr, delc);
        } 
    }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int[][] ans=image;
      int iniCol = image[sr][sc];
      int[] delr = {-1, 0, 1, 0};
      int[] delc = {0, -1, 0, 1};
      dfs(image,ans, sr, sc, color, iniCol,delr,delc); 
      return ans;  
    }
}