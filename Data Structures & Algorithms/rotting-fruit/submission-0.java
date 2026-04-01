class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int visited[][] = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0, minutesElapsed = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2)
                    q.add(new int[]{r, c, 0});
                else if(grid[r][c] == 1)
                    freshOranges++;
            }
        }

        while(!q.isEmpty()){
            int currCell[] = q.poll();

            for(int dir[] : DIRECTIONS){
                int row = dir[0] + currCell[0];
                int col = dir[1] + currCell[1];
                int time = currCell[2];
                minutesElapsed = Math.max(time, minutesElapsed);
                if(row >= 0 && col >= 0 && row < grid.length &&
                col < grid[0].length && visited[row][col] == 0 &&
                grid[row][col] == 1){
                    freshOranges--;
                    visited[row][col] = 2;
                    q.add(new int[]{row, col, time + 1});
                }
            }
        }
        return freshOranges == 0 ? minutesElapsed : -1;
    }
}
