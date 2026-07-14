class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int cells = 0, left = 0, right = cols - 1, up = 0, down = rows - 1;
        List<Integer> result = new ArrayList<>();

        while(cells < rows * cols){
            for(int c = left; c <= right; c++){
                result.add(matrix[up][c]);
                cells++;
            }
            up++;
            for(int d = up; d <= down; d++){
                result.add(matrix[d][right]);
                cells++;
            }
            right--;
            if(up <= down){
                for(int c = right; c >= left; c--){
                    result.add(matrix[down][c]);
                    cells++;
                }
                down--;
            }
            if(left <= right){
                for(int u = down; u >= up; u--){
                    result.add(matrix[u][left]);
                    cells++;
                }
                left++;
            }
        }
        return result;
    }
}
