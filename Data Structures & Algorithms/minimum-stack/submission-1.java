class MinStack {
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.add(val);
    }
    
    public void pop() {
      stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    // 5, 0, 2, 4
    public int getMin() {
       Stack<Integer> temp = new Stack<>();

       int mini = stack.peek();

        while(!stack.isEmpty()){
            mini = Math.min(mini, stack.peek());
            temp.add(stack.pop());
        }

        while(!temp.isEmpty()){
            stack.push(temp.pop());

        }

        return mini;
    }
}
