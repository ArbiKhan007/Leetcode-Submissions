class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos=0;
        int neg=0;
        int[] res=new int[nums.length];
        int idx=0;

        while(pos<nums.length&&neg<nums.length){
            if(nums[pos]>0&&nums[neg]<0){
                res[idx++]=nums[pos++];
                res[idx++]=nums[neg++];
            }else if(nums[pos]<0){
                pos++;
            }else if(nums[neg]>0){
                neg++;
            }
        }

        return res;
    }
}