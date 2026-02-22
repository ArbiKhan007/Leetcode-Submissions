class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int[] max=new int[n];
        int[] min=new int[n];

        min[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            min[i]=Math.min(nums[i], min[i-1]);
        }

        max[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            max[i]=Math.max(nums[i], max[i+1]);
        }

        for(int i=1;i<n;i++){
            //System.out.println(max[i]+":"+min[i]);
            if(max[i]>nums[i]&&min[i]<nums[i]) return true;
        }

        return false;
    }
}