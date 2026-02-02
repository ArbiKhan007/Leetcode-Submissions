class StockSpanner {
    Stack<Pair> st=new Stack<> ();
    int idx=-1;
    public StockSpanner() {
        st.push(new Pair(-1, -1));
    }
    
    public int next(int price) {
        idx++;
        while(!st.isEmpty()&&st.peek().val<=price){
            st.pop();
        }

        int ans=0;
        if(st.isEmpty()){
            ans=idx+1;
        }else{
            ans=idx-st.peek().idx;
        }

        st.push(new Pair(price, idx));
        return ans;
    }
}

class Pair{
    int val,idx;
    Pair(int val, int idx){
        this.val=val;
        this.idx=idx;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */