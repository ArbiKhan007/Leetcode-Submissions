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
    public boolean isBalanced(TreeNode root) {
        if(helper(root)>=1e4){
            return false;
        }

        return true;
    }

    public int helper(TreeNode root){
        if(root==null) return 0;

        int left=helper(root.left);
        int right=helper(root.right);

        System.out.println(root.val+" "+left+" "+right);

        if(Math.abs(left-right)<=1){
            return 1+Math.max(left, right);
        }

        return (int) 1e4;
    }
}