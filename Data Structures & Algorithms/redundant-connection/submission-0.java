class Solution {
    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        public boolean union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);

            if (root1 == root2)
                return false;

            if (rank[root1] > rank[root2])
                parent[root2] = parent[root1];
            else if (rank[root1] < rank[root2])
                parent[root1] = parent[root2];
            else {
                parent[root2] = root1;
                rank[root1]++;
            }
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        UnionFind uf = new UnionFind(size + 1);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[0];
    }
}
