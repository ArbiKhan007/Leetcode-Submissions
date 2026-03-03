class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> st=new Stack<> ();
        st.push(new StringBuilder());  // base layer
        for(char c:s.toCharArray()){
            if(c=='('){
                st.push(new StringBuilder());
            }else if(c==')'){
                StringBuilder top=st.pop().reverse();
                if(st.isEmpty()) st.push(top);
                else st.peek().append(top);
            }else if(!st.isEmpty()){
                st.peek().append(c);
            }
        }

        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()) res.append(st.pop());

        return res.toString();
    }
}