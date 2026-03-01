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
        while(!prim.isEmpty()){
            second.push(prim.pop());
        }

        int res=second.pop();

        while(!second.isEmpty()){
            prim.push(second.pop());
        }

        return res;
    }
    
    public int peek() {
        while(!prim.isEmpty()){
            second.push(prim.pop());
        }

        int res=second.peek();

        while(!second.isEmpty()){
            prim.push(second.pop());
        }
        return res;
    }
    
    public boolean empty() {
        return prim.isEmpty();
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