class Solution {

    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    boolean union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return false;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        }
        else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        }
        else {
            parent[pb] = pa;
            rank[pa]++;
        }

        return true;
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (isConnected[i][j] == 1) {

                    if (union(i, j)) {
                        components--;
                    }
                }
            }
        }

        return components;
    }
}