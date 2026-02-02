class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map=new HashMap<> ();
        int[] res=new int[nums1.length];
        int idx=0;

        for(int i=0;i<nums1.length;i++) res[i]=-1;

        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i], i);
        }

        for(int num:nums1){
            int j=map.get(num)+1;
            System.out.println(j);
            for(;j<nums2.length;j++){
                if(nums2[j]>num){
                    res[idx]=nums2[j];
                    break;
                }
            }

            idx++;
        }

        return res;
    }
}