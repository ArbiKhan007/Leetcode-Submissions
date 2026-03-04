class Solution {
    public int numSub(String s) {
        int count=0,l=0,r=0;
        int mod=(int)1e9+7;

        while(r<s.length()){
            if(s.charAt(r)=='0'){
                l=r+1;
                r++;
                continue;
            }else{
                count=(count+r-l+1)%mod;
            }

            r++;
        }

        return count;
    }
}