class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islandCount = 0;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == '1'){
                    islandCount++;
                    bfs(row, col, grid);
                }
            }
        }
        return islandCount;
    }

    public void bfs(int row, int col, char[][] grid){
        grid[row][col] = '0';
        Queue<int[]> islandQueue = new LinkedList<>();
        islandQueue.add(new int[]{row, col});

        while(!islandQueue.isEmpty()){
        int[] currPair = islandQueue.poll();
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for(int dir[] : dirs){
                int currRow = currPair[0] + dir[0];
                int currCol = currPair[1] + dir[1];

                if(currRow < 0 || currRow >= grid.length || currCol < 0 || currCol >= grid[0].length || grid[currRow][currCol] == '0'){
                    continue;
                }
                islandQueue.add(new int[]{currRow, currCol});
                grid[currRow][currCol] = '0';
            }
        }

    }
}
