class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                if (dfs(i, graph, color) == false)
                    return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, int[][] graph, int[] color) {
        for (int i = 0; i < graph[node].length; i++) {
            int neighbour = graph[node][i];
            if (color[neighbour] == -1) {
                color[neighbour] = 1 - color[node];

                if ((dfs(neighbour, graph, color) == false))
                    return false;
            } else if (color[neighbour] == color[node]) {
                return false;
            }
        }
        return true;
    }
}