class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];

        int n=nums.length;
        int pref=1;
        int suff=1;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(pref==0) pref=1;
            if(suff==0) suff=1;

            pref*=nums[i];
            suff*=nums[n-i-1];

            res=Math.max(res, Math.max(pref, suff));
        }

        return res;
    }
}