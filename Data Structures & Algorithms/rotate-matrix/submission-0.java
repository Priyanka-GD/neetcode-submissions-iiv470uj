class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    public void transpose(int[][] matrix){
        int len = matrix.length;
        for(int r = 0; r < len; r++){
            for(int c = r + 1; c < len; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }

    public void reverse(int[][] matrix){
        int len = matrix.length;
        for(int r = 0; r < len; r++){
            for(int c1 = 0, c2 = len - 1; c1 < c2 ; c1++, c2--){
                int temp = matrix[r][c1];
                matrix[r][c1] = matrix[r][c2];
                matrix[r][c2] = temp;
            }
        }
    }
}
