class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap<> ();
        int[] res=new int[2];

        for(int i=0;i<nums.length;i++){
            int rem=target-nums[i];
            if(map.containsKey(rem)&&map.get(rem)!=i){
                res[0]=map.get(rem);
                res[1]=i;
            }

            map.put(nums[i], i);
        }

        return res;
    }
}