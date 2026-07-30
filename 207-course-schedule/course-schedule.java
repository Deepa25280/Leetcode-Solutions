class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            graph[prerequisite].add(course);
        }

        boolean vis[] = new boolean[numCourses];
        boolean st[] = new boolean[numCourses];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, st, i)) {
                    return false;
                }
            }
        }
        return true;

    }

    public boolean detectCycleUtil(ArrayList<Integer>[] graph, boolean vis[], boolean st[], int curr) {
        vis[curr] = true;
        st[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            int dest = graph[curr].get(i);

            if (st[dest]) {
                return true;
            }
            if (!vis[dest]) {
                if (detectCycleUtil(graph, vis, st, dest)) {
                    return true;
                }
            }
        }
        st[curr] = false;
        return false;
    }

}