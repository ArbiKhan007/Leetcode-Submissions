class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        HashSet<Character> set=new HashSet<> ();
        int maxLen=0;
        while(r<s.length()){
            char c=s.charAt(r);
            while(set.contains(c)){
                char d=s.charAt(l);
                set.remove(d);
                l++;
            }
            set.add(c);
            maxLen=Math.max(maxLen, r-l+1);
            r++;
        }

        return maxLen;
    }
}