class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(checkWordExists(0, board, row, col, visited, word))
                    return true;
            }
        }
        return false;
    }
    private boolean checkWordExists(int wordIdx, char[][] board, int row, 
            int col, boolean[][] visited, String word)
    {
        if(wordIdx == word.length())
            return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
                visited[row][col] || word.charAt(wordIdx) != board[row][col])
            return false;
        visited[row][col] = true;

        if(checkWordExists(wordIdx + 1, board, row - 1, col, visited, word) ||
            checkWordExists(wordIdx + 1, board, row, col + 1, visited, word) ||
            checkWordExists(wordIdx + 1, board, row + 1, col, visited, word) ||
            checkWordExists(wordIdx + 1, board, row, col - 1, visited, word))
            return true;
        visited[row][col] = false;
        return false;   
    }
}
