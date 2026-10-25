class Solution {
    public class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private void bfs(char[][] grid, int[][] vis, int sr, int sc) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));
        vis[sr][sc] = 1;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int nr = cur.r;
            int nc = cur.c;
            int[] delr = { -1, 0, 1, 0 };
            int[] delc = { 0, -1, 0, 1 };
            for (int i = 0; i < 4; i++) {
                int nrow = nr + delr[i];
                int ncol = nc + delc[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    q.offer(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;

                }

            }

        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] != 1 && grid[i][j] == '1') {
                    cnt++;
                    bfs(grid, vis, i, j);
                }
            }
        }

        return cnt;
    }

}