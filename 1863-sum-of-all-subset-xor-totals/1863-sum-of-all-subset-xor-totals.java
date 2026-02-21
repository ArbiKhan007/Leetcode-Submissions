class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    public int helper(int[] nums, int i, int total){
        if(i==nums.length) return total;

        int take=helper(nums, i+1, total^nums[i]);
        int notTake=helper(nums, i+1, total);

        return take+notTake;
    }
}