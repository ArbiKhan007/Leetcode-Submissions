class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res=new int[nums1.length];
        Map<Integer, Integer> map=new HashMap<> ();
        int idx=0;

        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }

        for(int num:nums1){
            int idx1=map.get(num);
            boolean found=false;
            for(int i=idx1+1;i<nums2.length;i++){
                if(nums2[i]>num){
                    found=true;
                    res[idx++]=nums2[i];
                    break;
                }
            }
            if(!found){
                res[idx++]=-1;
            }
        }

        return res;
    }
}