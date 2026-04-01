class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int inDegree[] = new int[numCourses];
        for (int idx = 0; idx < numCourses; idx++) {
            adjList.add(new ArrayList<>());
        }
        for (int prerequisite[] : prerequisites) {
            adjList.get(prerequisite[0]).add(prerequisite[1]);
            inDegree[prerequisite[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (inDegree[course] == 0)
                q.add(course);
        }
        int courseTaken = 0;

        while (!q.isEmpty()) {
            int currCourse = q.poll();
            courseTaken++;
            for (int nextCourse : adjList.get(currCourse)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0)
                    q.add(nextCourse);
            }
        }
        return numCourses == courseTaken ? true : false;
    }
}
