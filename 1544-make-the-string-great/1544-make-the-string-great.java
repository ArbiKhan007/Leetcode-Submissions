class Solution {
    public String makeGood(String s) {
        if(s.length()==1) return s;

        Stack<Character> st=new Stack<> ();

        for(char c:s.toCharArray()){
            if(!st.isEmpty()
                &&
            (c!=st.peek()&&(Character.toLowerCase(c)==st.peek()||c==Character.toLowerCase(st.peek())))){
                st.pop();
            }else{
                st.push(c);
            }
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());

        return sb.reverse().toString();
    }
}