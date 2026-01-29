/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev=null;
    int minDiff=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return minDiff;
    }

    public void helper(TreeNode root){
        if(root==null) return;

        helper(root.left);
        if(prev!=null){
            minDiff=Math.min(minDiff, root.val-prev.val);
        }
        prev=root;
        helper(root.right);
    }
}