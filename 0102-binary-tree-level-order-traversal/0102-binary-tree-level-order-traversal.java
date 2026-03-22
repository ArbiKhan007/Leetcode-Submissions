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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<> ();

        if(root==null) return res;

        Queue<TreeNode> q=new LinkedList<> ();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> list=new ArrayList<> ();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode p=q.poll();
                if(p!=null) list.add(p.val);
                if(p!=null&&p.left!=null) q.add(p.left);
                if(p!=null&&p.right!=null) q.add(p.right);
            }
            res.add(list);
        }

        return res;
    }
}