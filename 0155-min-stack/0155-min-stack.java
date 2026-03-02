class MinStack {
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStack() {
    
    }
    
    public void push(int val) {
        normal.push(val);
        if(min.isEmpty()||val<=min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        int removed=normal.pop();

        if(removed==min.peek()) min.pop();
    }
    
    public int top() {
        return normal.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */