class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos=-1;
        int neg=-1;
        int[] res=new int[nums.length];
        int idx=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                pos=i;
                break;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                neg=i;
                break;
            }
        }

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