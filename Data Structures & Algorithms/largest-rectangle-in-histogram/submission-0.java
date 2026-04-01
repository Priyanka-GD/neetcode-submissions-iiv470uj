class Solution {
    public int largestRectangleArea(int[] heights) {
        int heightsLen = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < heightsLen; i++) {
            // If the current height is less than the height of the bar at the stack's top index
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                // If the stack is empty, it means the popped height was the smallest
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? heightsLen : heightsLen - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
