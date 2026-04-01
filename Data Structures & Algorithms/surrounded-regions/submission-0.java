class Solution {
    Queue<int[]> q = new LinkedList<>();

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        checkLeftAndRightCol(board, rows, cols);
        checkUpperAndLowerRow(board, rows, cols);
        checkNeighbors(board, rows, cols);
        updateBoard(board, rows, cols);
    }

    private void checkLeftAndRightCol(char[][] board, 
                                int rows, int cols) {
        for(int row = 0; row < rows; row++){
            if(board[row][0] == 'O'){
                board[row][0] = 'T';
                q.add(new int[]{row, 0});
            }
            
            if(board[row][cols - 1] == 'O'){
                board[row][cols - 1] = 'T'; 
                q.add(new int[]{row, cols - 1});
            }
        }
    }

    private void checkUpperAndLowerRow(char[][] board,
            int rows, int cols) {
        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O') {
                board[0][col] = 'T';
                q.add(new int[] { 0, col });
            }

            if (board[rows - 1][col] == 'O') {
                board[rows - 1][col] = 'T';
                q.add(new int[] { rows - 1, col });
            }
        }
    }

    private void checkNeighbors(char[][] board, int rows, int cols) {
        int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int[] point = q.poll();

            for(int dir[] : dirs){
                int row = dir[0] + point[0];
                int col = dir[1] + point[1];

                if(row >= 0 && col >= 0 && row < rows &&
                col < cols && board[row][col] == 'O'){
                    board[row][col] = 'T';
                    q.add(new int[]{row, col});
                }
            }
        }
    }

    public void updateBoard(char[][] board, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O')
                    board[row][col] = 'X';
                else  if (board[row][col] == 'T')
                    board[row][col] = 'O';
            }
        }
    }

}