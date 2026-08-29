class Solution {

    public boolean dfs(int V , boolean[] visited , boolean[] path, List<List<Integer>> adj)
    {
        visited[V] = true;
        path[V] = true;
        for(int neigh : adj.get(V))
        {
            if(!visited[neigh])
            {
                if(dfs(neigh,visited,path,adj))
                return true;
            }
            else if(path[neigh])
            {
                return true;
            }
        }
        path[V] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u); // i think its oposite~
        }

        boolean visited[] = new boolean[numCourses];
        boolean path[] = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, path, adj))
                    return false;
            }
        }
        return true;
    }
}