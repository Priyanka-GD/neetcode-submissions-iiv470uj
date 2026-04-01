class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int result[] = new int[temperatures.length];

        for(int idx = 0; idx < temperatures.length; idx++){
            while(!stack.isEmpty() 
                && temperatures[stack.peek()] < temperatures[idx]){
                int currDay = stack.pop();
                result[currDay] = idx - currDay;
            }
            stack.add(idx);
        }

        return result;
    }
}
