class MinStack {
    Stack<Integer> primaryStack;
    Stack<Integer> minStack;

    public MinStack() {
        primaryStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(primaryStack.empty()) {
            primaryStack.push(val);
            minStack.push(val);
        } else {
            minStack.push(Math.min(minStack.peek(), val));
            primaryStack.push(val);
        }
    }
    
    public void pop() {
        primaryStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return primaryStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
