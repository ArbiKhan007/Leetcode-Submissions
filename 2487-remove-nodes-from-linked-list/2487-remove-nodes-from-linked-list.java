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

        Collections.reverse(st);

        ptr=head;
        while(!st.isEmpty()){
            ptr.val=st.pop();
            
            if(st.isEmpty()) ptr.next=null;
            ptr=ptr.next;
        }

        return head;
    }
}