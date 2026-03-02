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
    public void reorderList(ListNode head) {
        ListNode slow=head, fast=head.next;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode ptr=head;
        ListNode ptr2=slow.next;
        slow.next=null;
        ListNode prev=null;

        while(ptr2!=null){
            ListNode next=ptr2.next;
            ptr2.next=prev;
            prev=ptr2;
            ptr2=next;
        }

        ptr2=prev;

        while(ptr2!=null){
            ListNode next=ptr.next;
            ptr.next=ptr2;
            ListNode next2=ptr2.next;
            ptr2.next=next;

            ptr=next;
            ptr2=next2;
        }
    }
}