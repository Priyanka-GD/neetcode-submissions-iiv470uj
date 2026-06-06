class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;

        int left = 0, right = heights.length - 1;

        while(left < right){

            int width = right - left;
            int length = Math.min(heights[right], heights[left]);
            maxArea = Math.max(maxArea, width * length);
            if(heights[left] <= heights[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
