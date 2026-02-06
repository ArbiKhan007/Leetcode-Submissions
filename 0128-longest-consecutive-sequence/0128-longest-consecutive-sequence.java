class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<> ();
        int longest=0;

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        for(Integer i:set){
            if(!set.contains(i-1)){
                int len=1;
                int next=i+1;
                while(set.contains(next)){
                    len++;
                    next++;
                }
                longest=Math.max(longest, len);
            }
        }

        return longest;
    }
}