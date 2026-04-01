class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Below code will follow khan's algorithm- Toposort
        // Linear ordering of DAG, with no cycle, if a edge u --> v, then u should always come before v
        List<List<Integer>> adjacencyList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] inDegree= new int[numCourses];
        for(int i = 0 ; i < numCourses; i++)
        {
           adjacencyList.add(new ArrayList<>());
        }
        for(int prerequisite[] : prerequisites)
        {
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses; i++)
        {
            if(inDegree[i] == 0)
                queue.add(i);
        }
        int nodeVisited = 0;
        while(!queue.isEmpty())
        {
            int course = queue.poll();
            nodeVisited++;
            list.add(course);
            for(int adjacent : adjacencyList.get(course))
            {
                inDegree[adjacent]--;
                if(inDegree[adjacent] == 0)
                    queue.add(adjacent);
            }
        }
        if(nodeVisited != numCourses)
            list.clear();
        int size = list.size();
        int[] results = new int[size];
        int idx = 0;
        for(int i = 0 ; i < size; i++)
            results[i] = list.get(i);
        return results;  
    }
}