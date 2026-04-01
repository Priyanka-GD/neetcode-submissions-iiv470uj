class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int high = (row * col) - 1, low = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            int currRow = mid / col;
            int currCol = mid % col;
            if(matrix[currRow][currCol] == target)
                return true;
            else if(matrix[currRow][currCol] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}
