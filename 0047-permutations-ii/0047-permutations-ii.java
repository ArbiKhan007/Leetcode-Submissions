class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<> ();
        dfs(nums, 0, res);
        return res;
    }

    public void dfs(int[] nums, int start, List<List<Integer>> res){
        if(start==nums.length){
            List<Integer> list=new ArrayList<> ();
            for(int num:nums) list.add(num);
            res.add(list);
            return;
        }

        Set<Integer> used=new HashSet<> ();
        
        for(int i=start;i<nums.length;i++){
            if(used.contains(nums[i])) continue;

            used.add(nums[i]);

            swap(nums,i,start);
            dfs(nums, start+1, res);
            swap(nums,i,start);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}