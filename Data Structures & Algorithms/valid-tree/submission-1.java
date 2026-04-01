class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> adjList = new ArrayList<>();

        for(int edge = 0; edge < n; edge++)
            adjList.add(new ArrayList<>());
        
        for(int edge[] : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        dfs(adjList, visited, 0);
        return visited.size() == n;
    }

    private void dfs(List<List<Integer>> adjList, Set<Integer> visited, int startNode){
        if (visited.contains(startNode))
            return;
        visited.add(startNode);
        for(int neighborNode : adjList.get(startNode)){
            dfs(adjList, visited, neighborNode);
        }
    }
}
