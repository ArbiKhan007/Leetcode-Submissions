/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res=new ArrayList<> ();
        if(root==null) return res;
        Stack<Node> st=new Stack<> ();
        st.push(root);

        while(!st.isEmpty()){
            Node p=st.pop();
            res.add(p.val);

            for(int i=p.children.size()-1;i>=0;i--){
                st.push(p.children.get(i));
            }
        }

        return res;
    }
}