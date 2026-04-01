class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int node = 0; node < n; node++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int connectedComponents = 0;
        boolean[] visited = new boolean[n];

        for(int node = 0; node < n; node++){
            if(!visited[node]){
               connectedComponents++;
               dfs(node, visited, adjList); 
            }
        }
        return connectedComponents;
    }

    public void dfs(int node, boolean[] visited, List<List<Integer>> adjList){
        visited[node] = true;
        for(int neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, visited, adjList);
            }
        }
    }
}
