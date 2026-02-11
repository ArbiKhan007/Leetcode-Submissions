class Solution {
    public void sortColors(int[] nums) {
        int countZ=0, countO=0, countT=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                countZ++;
            }else if(nums[i]==1){
                countO++;
            }else{
                countT++;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(countZ>0){
                nums[i]=0;
                countZ--;
                continue;
            }

            if(countO>0){
                nums[i]=1;
                countO--;
                continue;
            }

            if(countT>0){
                nums[i]=2;
                countT--;
            }
        }
    }
}