class FreqStack {
    Map<Integer, Integer> freq=new HashMap<> ();
    Map<Integer, Stack<Integer>> groups=new HashMap<> ();
    int maxFreq=0;
    public FreqStack() {
    }
    
    public void push(int val) {
        int f=freq.getOrDefault(val, 0)+1;
        freq.put(val, f);
        
        if(f>maxFreq){
            maxFreq=f;
        }

        groups.computeIfAbsent(f, z -> new Stack<> ()).push(val);
    }
    
    public int pop() {
        int val=groups.get(maxFreq).pop();
        freq.put(val, freq.get(val)-1);

        if(groups.get(maxFreq).isEmpty()){
            maxFreq--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */