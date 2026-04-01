class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Set<Integer> seen = new HashSet<>();
        dfs(0, adjList, seen);
        return seen.size() == n;
    }

    private void dfs(int node, List<List<Integer>> adjList, Set<Integer> seen) {
        if (seen.contains(node))
            return;
        seen.add(node);
        for (int neighbor : adjList.get(node))
            dfs(neighbor, adjList, seen);
    }
}
