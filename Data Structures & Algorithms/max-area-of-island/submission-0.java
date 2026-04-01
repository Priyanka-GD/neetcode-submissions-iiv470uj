class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        boolean visited[][] = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    int area = bfs(row, col, grid, visited);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int bfs(int row, int col, int[][] grid, boolean visited[][]) {

        visited[row][col] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { row, col });
        int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int count = 1;

        while (!queue.isEmpty()) {
            int currCell[] = queue.poll();
            for (int dir[] : dirs) {
                int currRow = dir[0] + currCell[0];
                int currCol = dir[1] + currCell[1];

                if (currRow >= 0 && currRow < grid.length &&
                        currCol >= 0 && currCol < grid[0].length &&
                        !visited[currRow][currCol] &&
                        grid[currRow][currCol] == 1) {
                    visited[currRow][currCol] = true;
                    queue.add(new int[] { currRow, currCol });
                    count++;
                }
            }
        }
        return count;
    }
}
