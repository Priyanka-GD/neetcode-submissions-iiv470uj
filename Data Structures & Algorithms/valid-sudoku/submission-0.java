class Solution {
    public boolean isValidSudoku(char[][] board) {
        return checkRowsForDuplicates(board) && checkColumnsForDuplicates(board)
                && checkBoxesForDuplicates(board);
    }

    private boolean checkRowsForDuplicates(char[][] board) {
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char value = board[row][col];
                if (value == '.')
                    continue;
                if (seen.contains(value))
                    return false;
                seen.add(value);
            }
        }
        return true;
    }

    private boolean checkColumnsForDuplicates(char[][] board) {
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char value = board[row][col];
                if (value == '.')
                    continue;
                if (seen.contains(value))
                    return false;
                seen.add(value);
            }
        }
        return true;
    }

    private boolean checkBoxesForDuplicates(char[][] board) {
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                Set<Character> seen = new HashSet<>();
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        char value = board[boxRow + row][boxCol + col];
                        if (value == '.')
                            continue;
                        if (seen.contains(value))
                            return false;
                        seen.add(value);
                    }
                }
            }
        }
        return true;
    }
}
