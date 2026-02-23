class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res=new int[nums1.length];
        Map<Integer, Integer> map=new HashMap<> ();
        int idx=0;

        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }

        Stack<Integer> st=new Stack<> ();
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty()&&st.peek()<=nums2[i]){
                st.pop();
            }

            if(st.isEmpty()){
                st.push(nums2[i]);
                nums2[i]=-1;
            }else{
                int orig=nums2[i];
                nums2[i]=st.peek();
                st.push(orig);
            }
        }

        for(int num:nums1){
            res[idx++]=nums2[map.get(num)];
        }

        return res;
    }
}