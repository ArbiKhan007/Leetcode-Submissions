class MyQueue {
    Stack<Integer> prim, second;
    public MyQueue() {
        prim=new Stack<> ();
        second=new Stack<> ();
    }
    
    public void push(int x) {
        prim.push(x);
    }
    
    public int pop() {
        shift();
        return second.pop();
    }
    
    public int peek() {
        shift();
        return second.peek();
    }
    
    public boolean empty() {
        return prim.isEmpty()&&second.isEmpty();
    }

    private void shift(){
        if(second.isEmpty()){
            while(!prim.isEmpty()){
                second.push(prim.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */