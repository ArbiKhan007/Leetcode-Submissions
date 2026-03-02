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

        ListNode second=slow.next;
        slow.next=null;
        ListNode prev=null;

        while(second!=null){
            ListNode next=second.next;
            second.next=prev;
            prev=second;
            second=next;
        }

        second=prev;
        ListNode first=head;

        while(second!=null){
            ListNode fNext=first.next;
            first.next=second;
            ListNode sNext=second.next;
            second.next=fNext;

            first=fNext;
            second=sNext;
        }
    }
}