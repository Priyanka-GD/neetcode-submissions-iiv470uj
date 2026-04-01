class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Build adjacency list: prereq -> course
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
        }

        int[] state = new int[numCourses]; // 0=unvisited, 1=visiting, 2=visited

        // Run DFS from every node
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(i, graph, state)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> graph, int[] state) {

        if (state[node] == 1) return true;  // cycle found
        if (state[node] == 2) return false; // already processed

        state[node] = 1; // mark as visiting

        for (int neighbor : graph.get(node)) {
            if (hasCycle(neighbor, graph, state)) {
                return true;
            }
        }

        state[node] = 2; // mark as visited
        return false;
    }
}
