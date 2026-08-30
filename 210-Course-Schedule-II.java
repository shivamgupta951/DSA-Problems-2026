class Solution {

    public void dfs(int V, boolean[] visited, Stack<Integer> s, List<List<Integer>> adj) {
        visited[V] = true;
        for (int neigh : adj.get(V)) {
            if (!visited[neigh]) {
                dfs(neigh, visited, s, adj);
            }
        }
        s.push(V);
    }

    public boolean cycleCheck(int V, boolean[] vis, boolean[] path, List<List<Integer>> adj) {
        vis[V] = true;
        path[V] = true;
        for (int neigh : adj.get(V)) {
            if (!vis[neigh]) {
                if (cycleCheck(neigh, vis, path, adj))
                    return true;
            } else if (path[neigh]) {
                return true;
            }
        }
        path[V] = false;
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
        }

        boolean cycle = false;
        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (cycleCheck(i, vis, path, adj))
                    cycle = true;
            }
        }

        if (cycle)
            return new int[] {};

        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(i, visited, s, adj);
            }
        }

        int ans[] = new int[s.size()];
        int idx = 0;
        while (!s.isEmpty()) {
            ans[idx++] = s.pop();
        }
        return ans;
    }
}