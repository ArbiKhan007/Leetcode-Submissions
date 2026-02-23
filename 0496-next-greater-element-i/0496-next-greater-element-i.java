class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res=new int[nums1.length];
        int idx=0;
        for(int num:nums1){
            for(int i=0;i<nums2.length;i++){
                if(nums2[i]==num){
                    boolean found=false;
                    for(int j=i+1;j<nums2.length;j++){
                        if(nums2[j]>num){
                            res[idx++]=nums2[j];
                            found=true;
                            break;
                        }
                    }

                    if(!found){
                        res[idx++]=-1;
                    }
                }
            }
        }

        return res;
    }
}