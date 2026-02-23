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
        ListNode newHead=reverse(head);

        int max=newHead.val;
        ListNode ptr=newHead;
        while(ptr.next!=null){
            if(ptr.next.val<max){
                ptr.next=ptr.next.next;
            }else{
                ptr=ptr.next;
                max=ptr.val;
            }
        }

        return reverse(newHead);
    }

    public ListNode reverse(ListNode head){
        ListNode dummy=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=dummy;
            dummy=head;
            head=next;
        }
        return dummy;
    }
}