class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isRowElementUnique(board) && isColElementUnique(board) &&
            isBoxElementsUnique(board);
    }

    public boolean isRowElementUnique(char[][] board){
        for(int row = 0; row < 9; row++){
            Set<Character> seen = new HashSet<>();
            for(int col = 0; col < 9; col++){
                if(board[row][col] == '.')
                    continue;
                if(seen.contains(board[row][col]))
                    return false;
                seen.add(board[row][col]);
            }
        }
        return true;
    }

    public boolean isColElementUnique(char[][] board){
        for(int col = 0; col < 9; col++){
            Set<Character> seen = new HashSet<>();
            for(int row = 0; row < 9; row++){
                if(board[row][col] == '.')
                    continue;
                if(seen.contains(board[row][col]))
                    return false;
                seen.add(board[row][col]);
            }
        }
        return true;
    }

    public boolean isBoxElementsUnique(char[][] board){
        for(int rowBox = 0; rowBox < 9; rowBox += 3){
            for(int colBox = 0; colBox < 9; colBox += 3){
                Set<Character> seen = new HashSet<>();
                for(int row = 0; row < 3; row++){
                    for(int col = 0; col < 3; col++){
                        char val = board[row + rowBox][col + colBox];
                        if(val == '.')
                            continue;
                        if(seen.contains(val))
                            return false;
                        seen.add(val);
                    }
                }
            }
        }
        return true;
    }
}
