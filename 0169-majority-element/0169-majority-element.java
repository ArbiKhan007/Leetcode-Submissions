class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int curr=nums[0];
        int count=1;
        int majority=nums[0];
        int maxCount=0;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==curr){
                count++;
            }else{
                curr=nums[i];
                count=1;
            }

            if(count>maxCount){
                maxCount=count;
                majority=nums[i];
            }
        }

        return majority;
    }
}