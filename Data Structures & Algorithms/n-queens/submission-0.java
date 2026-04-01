class Solution {
    /* 
    The objective is to find a configuration 
    where no two queens are on the same row, column, or diagonal.
    */
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int row = 0; row < n ; row++){
            for(int col = 0; col < n; col++)
                board[row][col] = '.';
        }
        List<List<String>> answer = new ArrayList<>();
        dfs(0, board, answer);
        return answer;
    }

    private void dfs(int col, char[][] board,  List<List<String>> answer){
        if(col == board.length){
            answer.add(construct(board));
            return;
        }
        for(int row = 0; row < board.length; row++){
            if(validate(row, col, board)){
                board[row][col] = 'Q';
                dfs(col + 1, board, answer);
                board[row][col] = '.';
            }
        }
    }

    private List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int row = 0; row < board.length; row++){
            String s = new String(board[row]);
            res.add(s);
        }
        return res;
    }

    private boolean validate(int row, int col, char[][] board){
        int r = row;
        int c = col;

        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q')
                return false;
            col--;
            row--;
        }

        row = r;
        col = c;

        while(col >= 0){
            if(board[row][col] == 'Q')
                return false;
            col--;
        }

        row = r;
        col = c;

        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q')
                return false;
            col--;
            row++;
        }
        return true; 
    }
}
