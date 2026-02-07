class Solution {
    public int countPartitions(int[] nums) {
        int total=0;
        int currTotal=0;
        int cnt=0;
        for(int num:nums){
            total+=num;
        }

        for(int i=0;i<nums.length-1;i++){
            currTotal+=nums[i];
            int partDiff=currTotal-(total-currTotal);
            if(partDiff%2==0) cnt++;
        }

        return cnt;
    }
}