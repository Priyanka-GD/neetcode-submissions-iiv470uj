class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(!("*/+-").contains(token)){
                stack.push(Integer.parseInt(token));
            }else{
                int second = stack.pop();
                int first = stack.pop();
                switch(token){
                    case "*" :
                        stack.push(first * second);
                        break;
                    case "/" :
                        stack.push(first / second);
                        break;
                    case "+" :
                        stack.push(first + second);
                        break;
                    case "-" :
                        stack.push(first - second);
                        break;
                }
            }
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }
}
