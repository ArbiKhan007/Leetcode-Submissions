/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    Stack<Integer> st=new Stack<> ();
    public int[] nextLargerNodes(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        helper(head, list);
        int[] res=new int[list.size()];
        int idx=0;
        for(int i:list) res[idx++]=i;
        return res;
    }

    public void helper(ListNode node, LinkedList<Integer> list){
        if(node==null) return;

        helper(node.next, list);
        while(!st.isEmpty()&&st.peek()<=node.val){
            st.pop();
        }
        if(st.isEmpty()) list.addFirst(0);
        else list.addFirst(st.peek());
        st.push(node.val);
    }
}