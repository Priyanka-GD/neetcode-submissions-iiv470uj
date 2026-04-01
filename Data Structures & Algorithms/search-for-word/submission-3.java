class Solution {
    public boolean exist(char[][] board, String word) {
        //Same cell may not be used in the word, means we need to keep track of ceels we have visited
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(word.charAt(0) == board[row][col]){
                    if(wordMatch(board, row, col, word, visited, 0))
                        return true;
                }
            }
        }
        return false;
    }
    private boolean wordMatch(char[][] board, int row, int col, 
        String word, boolean[][] visited, int idx){
            if(idx == word.length())
                return true;
            if(row >= board.length || row < 0 || col >= board[0].length || 
                col < 0 || visited[row][col] || word.charAt(idx) != board[row][col])
                return false;
            visited[row][col] = true;
            if(wordMatch(board, row + 1, col, word, visited, idx + 1) ||
                wordMatch(board, row, col - 1, word, visited, idx + 1) ||
                wordMatch(board, row - 1, col, word, visited, idx + 1) ||
                wordMatch(board, row, col + 1, word, visited, idx + 1))
                return true;
            visited[row][col] = false;
            return false;
    }
}
