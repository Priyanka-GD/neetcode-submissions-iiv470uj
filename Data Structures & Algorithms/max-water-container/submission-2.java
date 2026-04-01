class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1, maxArea = 0;
        while(left <= right){
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, width * height);
            if(heights[left] >= heights[right]){
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
