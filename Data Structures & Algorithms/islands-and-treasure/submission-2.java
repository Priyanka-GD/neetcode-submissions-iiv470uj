class Solution {
    private static final int LAND_CELL = Integer.MAX_VALUE;
    private static final int TREASURE_CELL = 0;
    private static final int EMPTY_CELL = -1;
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;

        if(rows == 0)
            return;

        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == TREASURE_CELL)
                    q.add(new int[]{row, col});
            }
        } 
        while(!q.isEmpty()){
            int[] point = q.poll();
            int currRow = point[0];
            int currCol = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = currRow + direction[0];
                int c = currCol + direction[1];
                if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != LAND_CELL) {
                    continue;
                }
                grid[r][c] = grid[currRow][currCol] + 1;
                q.add(new int[] { r, c });
            }
        }
    }
}
