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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list=new ArrayList<> ();
        helper(head, list);
        int[] res=new int[list.size()];
        int idx=0;
        for(int i:list) res[idx++]=i;
        return res;
    }

    public int helper(ListNode node, List<Integer> list){
        if(node==null) return Integer.MIN_VALUE;

        int next=helper(node.next, list);
        if(next>node.val){
            list.add(0, next);
        }else{
            list.add(0, 0);
        }

        return Math.max(next, node.val);
    }
}