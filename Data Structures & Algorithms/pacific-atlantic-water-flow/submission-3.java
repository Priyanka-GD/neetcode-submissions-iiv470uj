class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        // Pacific: top row + left col
        for (int r = 0; r < rows; r++) dfs(r, 0, pac, heights);
        for (int c = 0; c < cols; c++) dfs(0, c, pac, heights);

        // Atlantic: bottom row + right col
        for (int r = 0; r < rows; r++) dfs(r, cols - 1, atl, heights);
        for (int c = 0; c < cols; c++) dfs(rows - 1, c, atl, heights);

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] reachable, int[][] heights) {
        if (reachable[r][c]) return;
        reachable[r][c] = true;

        int rows = heights.length, cols = heights[0].length;
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

            // reverse-flow condition: next must be >= current
            if (heights[nr][nc] < heights[r][c]) continue;

            dfs(nr, nc, reachable, heights);
        }
    }
}
