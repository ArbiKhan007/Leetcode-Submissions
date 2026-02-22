class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<> ();
        dfs(nums, 0, res);
        return res;
    }

    public void dfs(int[] nums, int start, List<List<Integer>> res){
        if(start==nums.length){
            List<Integer> curr=new ArrayList<> ();
            for(int num:nums) curr.add(num);
            res.add(curr);
            return;
        }

        for(int i=start;i<nums.length;i++){
            swap(nums, start, i);
            dfs(nums, start+1, res);
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}