class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int answer[] = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int idx = 0; idx < temperatures.length; idx++){
            while(!stack.isEmpty() 
                && temperatures[stack.peek()] < temperatures[idx]){
                    int currDay = stack.pop();
                    int noOfDays = idx - currDay;
                    answer[currDay] = noOfDays;
                }
            stack.push(idx);
        }
        return answer;
    }
}
