class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map=new HashMap<> ();
        Stack<Integer> st=new Stack<> ();

        int m=nums1.length;
        int n=nums2.length;
        int[] res=new int[m];
        int[] nextGr=new int[n];
        int idx=0;

        for(int i=0;i<n;i++){
            map.put(nums2[i], i);
        }

        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                nextGr[i]=-1;
            }

            if(!st.isEmpty()&&st.peek()<nums2[i]){
                // pop all smaller elements
                while (!st.isEmpty() && st.peek() <= nums2[i]) {
                    st.pop();
                }

                nextGr[i] = st.isEmpty() ? -1 : st.peek();
            }

            if(!st.isEmpty()&&st.peek()>nums2[i]){
                nextGr[i]=st.peek();
            }

            st.push(nums2[i]);
        }

        for(int i=0;i<m;i++){
            res[idx++]=nextGr[map.get(nums1[i])];
        }

        return res;
    }
}