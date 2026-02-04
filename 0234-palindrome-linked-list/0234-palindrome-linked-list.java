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
    ListNode h=null;
    public boolean isPalindrome(ListNode head) {
        h=head;
        return helper(head);
    }

    public boolean helper(ListNode tail){
        if(tail==null) return true;
        if(!helper(tail.next)) return false;
        if(h.val==tail.val){
            System.out.println(h.val+" "+tail.val);
            h=h.next;
            return true;
        }

        return false;
    }
}