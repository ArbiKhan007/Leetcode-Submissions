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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> st=new Stack<> ();
        ListNode ptr=head;

        while(ptr!=null){
            while(!st.isEmpty()&&st.peek()<ptr.val){
                st.pop();
            }

            st.push(ptr.val);
            //System.out.println(st);
            ptr=ptr.next;
        }

        ListNode dummy=null;
        while(!st.isEmpty()){
            ListNode node=new ListNode(st.pop());
            node.next=dummy;
            dummy=node;
        }

        return dummy;
    }
}