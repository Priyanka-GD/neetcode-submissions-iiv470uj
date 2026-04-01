class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = cols - 1, up = 0, down = rows - 1;
        while(up <= down && left <= right){

            for(int r = left; r <= right; r++){
                result.add(matrix[up][r]);
            }
            up++;
            for(int d = up; d <= down; d++){
                result.add(matrix[d][right]);
            }
            right--;
            if(up <= down){
                for(int l = right; l >= left; l--){
                    result.add(matrix[down][l]);
                }
                down--;
            }

            if(left <= right){
                for(int u = down; u >= up; u--){
                    result.add(matrix[u][left]);
                }
                left++;
            }
        }
        return result;
    }
}
