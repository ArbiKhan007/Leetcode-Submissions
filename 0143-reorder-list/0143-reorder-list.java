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
        List<ListNode> list=new ArrayList<> ();
        ListNode ptr=head;
        while(ptr!=null){
            list.add(ptr);
            ptr=ptr.next;
        }

        int l=0,r=list.size()-1;
        while(l<r){
            ListNode temp=list.get(l).next;
            list.get(l).next=list.get(r);
            list.get(r).next=temp;
            l++;r--;
        }

        list.get(l).next = null;
    }
}